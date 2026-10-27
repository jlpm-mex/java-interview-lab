
import argparse
from pathlib import Path
import sys

ROOT = Path(__file__).resolve().parent.parent
EXERCISES_DIR = ROOT / "docs" / "exercises"
README_PATH = ROOT / "README.md"

START_MARKER = "<!-- EXERCISES_TABLE_START -->"
END_MARKER = "<!-- EXERCISES_TABLE_END -->"

REQUIRED_FIELDS = {
    "exercise",
    "title",
    "status",
    "concept",
    "time_complexity",
    "space_complexity",
}


def read_front_matter(path):
    lines = path.read_text(encoding="utf-8").splitlines()

    if not lines or lines[0].strip() != "---":
        raise ValueError(f"Missing front matter in {path.name}")

    try:
        end = lines.index("---", 1)
    except ValueError as exc:
        raise ValueError(f"Unclosed front matter in {path.name}") from exc

    metadata = {}

    for line in lines[1:end]:
        if ":" not in line:
            continue

        key, value = line.split(":", 1)
        metadata[key.strip()] = value.strip()

    missing = REQUIRED_FIELDS - metadata.keys()
    if missing:
        raise ValueError(
            f"Missing fields in {path.name}: {', '.join(sorted(missing))}"
        )

    return metadata


def generate_table():
    exercises = []

    for path in EXERCISES_DIR.glob("*.md"):
        metadata = read_front_matter(path)
        metadata["path"] = path.relative_to(ROOT).as_posix()
        exercises.append(metadata)

    exercises.sort(key=lambda item: item["exercise"])

    if not exercises:
        raise ValueError("No exercise Markdown files were found.")

    rows = [
        "| # | Exercise | Status | Concept | Time | Space |",
        "|---|---|---|---|---|---|",
    ]

    for item in exercises:
        rows.append(
            f"| {item['exercise']} "
            f"| [{item['title']}]({item['path']}) "
            f"| {item['status']} "
            f"| {item['concept']} "
            f"| `{item['time_complexity']}` "
            f"| `{item['space_complexity']}` |"
        )

    return "\n".join(rows)


def build_readme(readme):
    if readme.count(START_MARKER) != 1 or readme.count(END_MARKER) != 1:
        raise ValueError(
            "README.md must contain each exercise table marker exactly once."
        )

    start = readme.index(START_MARKER) + len(START_MARKER)
    end = readme.index(END_MARKER)

    if end < start:
        raise ValueError("The exercise table markers are in the wrong order.")

    table = generate_table()

    return (
        readme[:start]
        + "\n\n"
        + table
        + "\n\n"
        + readme[end:]
    )


def main():
    parser = argparse.ArgumentParser(
        description="Generate or verify the exercises table."
    )
    parser.add_argument(
        "--check",
        action="store_true",
        help="Check whether README.md is up to date without modifying it.",
    )
    args = parser.parse_args()

    readme = README_PATH.read_text(encoding="utf-8")
    expected_readme = build_readme(readme)

    if args.check:
        if expected_readme != readme:
            print("README.md is out of date.")
            print("Run: python3 scripts/generate_exercises_table.py")
            return 1

        print("README.md is up to date.")
        return 0

    README_PATH.write_text(expected_readme, encoding="utf-8")
    print("Updated README.md successfully.")
    return 0


if __name__ == "__main__":
    try:
        sys.exit(main())
    except (OSError, ValueError) as exc:
        print(f"Error: {exc}", file=sys.stderr)
        sys.exit(1)
