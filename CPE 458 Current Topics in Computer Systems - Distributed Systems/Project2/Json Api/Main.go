package main

import (
    "log"
    "net/http"
    "os"
)

// Node main
func main() {

    router := NewRouter()
    port := os.Args[1]

    log.Fatal(http.ListenAndServe(":" + port, router))
}