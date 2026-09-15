from pathlib import Path
import sys
from shutil import copy
import subprocess

# PROJECT STRUCTURE 
src_folder = Path(__file__).resolve().parent
root_folder = src_folder.parent

submission_file = src_folder / "submission-code.py"
submissions_folder = root_folder / "submissions"

# CONTRACT : python3 submit.py problem-name [submission-name] [commit-message]

if len(sys.argv) < 2:
    print("Usage: python3 submit.py <problem-name> [submission-name] [commit-message]")
    sys.exit(1)

problem_name = sys.argv[1]
submission_name = sys.argv[2] if len(sys.argv) >= 3 else problem_name
commit_message = sys.argv[3] if len(sys.argv) >= 4 else f"add {problem_name}"


destination_folder = submissions_folder / problem_name
destination_folder.mkdir(parents=True, exist_ok=True)


files = list(destination_folder.iterdir())
submission_order = len(files)

destination_submission = destination_folder / f"{submission_name}-{submission_order}.py"
copy(submission_file, destination_submission)


subprocess.run(["git", "add", "."], cwd=submissions_folder, check=True)
subprocess.run(["git", "commit", "-m", commit_message], cwd=root_folder, check=True)
subprocess.run(["git", "push", "origin", "main"], cwd=root_folder, check=True)