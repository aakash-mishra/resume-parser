package main

import (
	"fmt"
	"log"
	"os"
	"path/filepath"
	"strings"
	// "bytes"
	"code.sajari.com/docconv"
)

func main() {
	os.Chdir("../static")
	cur_dir, err := os.Getwd()
	if err != nil {
		fmt.Printf("Error.")
	}
	fmt.Printf("Current Working Direcotry: %s\n", cur_dir)
	iterate(cur_dir)
}

func iterate(path string) {
	filepath.Walk(path, func(path string, info os.FileInfo, err error) error {
		if err != nil {
			log.Fatalf(err.Error())
		}
		// fmt.Printf("Abs File Name: %s\n", path, info.Name())
		abs_file_name, e := path, info.Name()
		if e != "" {
		}
		if strings.HasSuffix(abs_file_name, ".pdf") {
			fmt.Println(abs_file_name)
			// content, err := 
			readPdf2(abs_file_name)
			// fmt.Printf(content)
		}
		return nil
	})
}
func readPdf2(path string) {
	fmt.Println(path)
	res, err := docconv.ConvertPath(path)
    if err != nil {
        fmt.Println(err)
    }
    fmt.Println(res)
}



