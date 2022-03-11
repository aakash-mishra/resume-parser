# resume-parser
Dependencies needed to compile the project in all three languages:
1. Python: pip install textract
2. GO: go get -u github.com/ledongthuc/pdf

To run the project, simply type `./evaluator.sh`. This will run the resume-parser on all the resumes present in the directory `./static` and will display the respective execution times. By default, we have commented the statemenet that will print all the skills present in a resume (in order to not flood system out). You can uncomment that statement in all 3 files (Driver.go, Driver.py and ReadingText.java) to see the resume-skills map.


References:
1. Skills dataset taken from: https://www.kaggle.com/maneeshdisodia/employment-skills
2. Golang learning resource: https://gobyexample.com/
3. Python Library: https://pypi.org/project/textract/
4. Go Library: https://github.com/ledongthuc/pdf
5. Java Library: https://pdfbox.apache.org/

