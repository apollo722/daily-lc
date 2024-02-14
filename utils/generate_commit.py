import subprocess
import sys
from datetime import datetime
from collections import defaultdict

def get_added_files():
    res = subprocess.check_output(["git", "diff", "--cached", "--name-only"], text=True)
    added_files = res.strip().split('\n')
    return added_files


def process_files(added_files):
    daily = []
    tags = defaultdict(list)

    for file in added_files:
        if file.startswith("daily/"):
            number = int(file.split('/')[1].split(' ')[0].lstrip('0'))
            daily.append(number)
        elif file.startswith("tags/"):
            tag, number = file.split('/')[1], int(file.split('/')[2].split(' ')[0].lstrip('0'))
            tags[tag].append(number)

    return daily, tags


def create_commit_message(daily, tags, date):
    message = f"{date}\n"
    if daily:
        daily_sorted = sorted(daily, key=lambda x: int(x))
        message += "Daily: " + ", ".join(map(str, daily_sorted)) + "\n"

    for tag in sorted(tags.keys()):
        tag_sorted = sorted(tags[tag], key=lambda x: int(x))
        message += f"{tag.capitalize()}: " + ", ".join(map(str, tag_sorted)) + "\n"

    return message.strip()


def commit_changes(commit_message):
    try:
        subprocess.run(["git", "commit", "-m", commit_message], check=True)
        print("Commit successful.")
    except subprocess.CalledProcessError as e:
        print(f"Error during commit: {e}")


if __name__ == "__main__":
    date_arg = sys.argv[1] if len(sys.argv) > 1 else datetime.now().strftime("%m/%d/%Y")

    added_files = get_added_files()
    daily, tags = process_files(added_files)
    commit_message = create_commit_message(daily, tags, date_arg)

    print("Generated commit message:")
    print(commit_message)

    commit_changes(commit_message)
