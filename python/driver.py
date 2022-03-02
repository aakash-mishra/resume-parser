import textract
import os
import time

def find_intersection(text_from_pdf, skills):
    words_in_pdf = text_from_pdf.split('\n')
    skills_in_pdf = []
    for skill in skills:
        if skill in words_in_pdf[0]:
            skills_in_pdf.append(skill)
    return skills_in_pdf

def main():
    start_time = time.time()
    os.chdir('../static')
    text_file = open("skills.txt", "r")
    skills = text_file.read().split('\n')
    all_resumes = os.listdir()
    for resume in all_resumes:
        if resume.endswith('.pdf'):
            skill_list = [] #list of skills for this resume
            text_from_pdf = str(textract.process(os.getcwd() + '/' + resume))
            skill_list = find_intersection(text_from_pdf, skills)
            # print("Skills found in this resume: " + str(skill_list))
    print("Total execution time: " + str ( (time.time() - start_time)) + " seconds")
if __name__ == "__main__":
    main()