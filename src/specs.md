### Auto Submission Script

The `submit.py` script should take the following arguments:

- `problem-name`: used to create the problem folder under `submissions/`.

- `submission-code.py`: the source file containing the submission code.
  For simplicity, the script can always read from a default file instead of pasting code directly into the terminal (assumes whatever is there to be the wanted submission).

- `submission-name` *(optional)*: custom name for the submission file.
  If omitted, use the default format:
  `{problem_name}-{submission-order}.py`

- `commit-message` *(optional)*: custom Git commit message.
  If omitted, automatically generate:
  `"add {problem-name}-{submission-order}"`

The script should then:

1. Create the problem folder if it does not exist.
2. Determine the next submission order.
3. Copy the submission code into the appropriate file.
4. Stage the changes.
5. Commit them.
6. Push them to the repository.


