package main

import (
	"fmt"
	"log"
	"os"
	"path/filepath"
	s "strings"
	"github.com/ledongthuc/pdf"
	"bytes"
	"time"
)

func main() {
	start_time := time.Now()
	// os.Chdir("../static")
	os.Chdir("static/")
	data, err := os.ReadFile("skills.txt")
	skills_data := string(data)

	cur_dir, err := os.Getwd()
	if err != nil {
		fmt.Printf("Error.")
	}
	// fmt.Printf("Current Working Direcotry: %s\n", cur_dir)
	iterate(cur_dir, skills_data)
	fmt.Println("[GO]Total execution time: ", time.Since(start_time) )
}

func iterate(path string, skills_data string)  {
	filepath.Walk(path, func(path string, info os.FileInfo, err error) error {
		if err != nil {
			log.Fatalf(err.Error())
		}
		abs_file_path := path
		
		if s.HasSuffix(abs_file_path, ".pdf") {
			pdf_data, err := readPdf(abs_file_path)
			if err != nil {
				fmt.Println("error while reading pdf")
			}
			skills_data_list := s.Split(skills_data, "\n")
			skills_of_this_resume := make([]string, 0)
			for i := 0; i < len(skills_data_list); i++ {
				if s.Contains(pdf_data, skills_data_list[i]) {
					skills_of_this_resume = append(skills_of_this_resume, skills_data_list[i])
				}
			}
			// fmt.Println("Skills of this resume: ", skills_of_this_resume)

		}
		return nil
	})
}

func readPdf(path string) (string, error) {
	f, r, err := pdf.Open(path)
    defer f.Close()
	if err != nil {
		return "", err
	}
	var buf bytes.Buffer
    b, err := r.GetPlainText()
    if err != nil {
        return "", err
    }
    buf.ReadFrom(b)
	return buf.String(), nil
}



