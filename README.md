## - DSA practice & notes

In this repo I aim to do the following:

- Store the DSA problems I work on in one place.
- Automate the submission process using a script that takes the problem name, submission name (optional), and target language. It automatically:
  - Creates the problem/language folders.
  - Copies the current submission into the appropriate folder, using a custom name or an incremented one.
  - Stages, commits, and pushes to GitHub with a meaningful commit message.
- Include docs and cheatsheets containing syntax references and DSA concepts, so I can quickly get back to the level I stopped at.

## How to use

From the repository root, run:

```bash
python3 src/submit.py <problem-name> [submission-name] --language <language> [--message <commit-message>]
```

Example:

```bash
python3 src/submit.py two-sum --language python
python3 src/submit.py two-sum optimized --language java --message "Add optimized solution"
```

## Project structure

```text
.
├── src/
│   ├── submit.py
│   └── submission.txt
├── submissions/
│   └── problem-name/
│       └── language/
│           └── submission-name-N.ext
└── docs/
    └── cheatsheets/
```


