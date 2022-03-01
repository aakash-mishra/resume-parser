import textract
import os
skills = []
def main():
    os.chdir('../static')
    all_resumes = os.listdir()
    for resume in all_resumes:
        print(os.getcwd() + '/' + resume)
        text = textract.process(os.getcwd() + '/' + resume)
        print(str(text))

if __name__ == "__main__":
    main()