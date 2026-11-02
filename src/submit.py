import argparse
from pathlib import Path
from shutil import copy
import subprocess

# PROJECT STRUCTURE 
src_folder = Path(__file__).resolve().parent
root_folder = src_folder.parent

submission_file = src_folder / "submission.txt"
submissions_folder = root_folder / "submissions"

supported_languages = {
    "python": "py",
    "javascript": "js",
    "typescript": "ts",
    "java": "java",
    "cpp": "cpp",
    "go": "go",
    "rust": "rs",
    "php": "php",
    "kotlin": "kt"
}

# CONTRACT : python3 submit.py problem-name [submission-name] --language --message
parser = argparse.ArgumentParser()

parser.add_argument("problem_name")
parser.add_argument("submission_name" , nargs="?")
parser.add_argument(
    "--language",
    required=True,
    choices=supported_languages.keys()
)
parser.add_argument("--message" )

args = parser.parse_args()

args.submission_name = args.submission_name or args.problem_name
args.message = args.message or f'added {args.submission_name} , {args.language}'

destination_folder = submissions_folder / args.problem_name / args.language
destination_folder.mkdir(parents=True, exist_ok=True)

files = list(destination_folder.iterdir())
submission_order = len(files)

destination_submission = destination_folder / f"{args.submission_name}-{submission_order}.{supported_languages[args.language]}"
copy(submission_file, destination_submission)

subprocess.run(["git", "add", "."], cwd=submissions_folder, check=True)
subprocess.run(["git", "commit", "-m", args.message], cwd=root_folder, check=True)
subprocess.run(["git", "push", "origin", "main"], cwd=root_folder, check=True)


