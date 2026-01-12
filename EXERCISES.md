# Command Line Practice Exercises

This exercise set focuses on `find`, `grep`, and file looping techniques that are essential for working with codebases and log files.

## Setup

Navigate to the `Command_Line_Practice` directory before starting these exercises.

```bash
cd Command_Line_Practice
```

---

## Part 0: Examining File Contents

### Exercise 0.1: Print out the contents of a file
Print out the contents of the EXERCISES.md file on the command line.

**Hint**: Use `cat` 

### Exercise 0.2: Display the contents of a file using a terminal 'pager' program
Show the contents of the EXERCISES.md file on the command line.  Make sure that you can scroll down and up - trying using both the arrow keys, the PageUp / PageDown keys, and also try the 'j' and 'k' keys (what do j & k do?)

**Hint**: Use `less` 

### Exercise 0.3: Search for a string using less
Show the contents of the EXERCISES.md file on the command line using `less`. Find a level three header (which starts with ###) by using the forward search command ( type `/` and then what you're looking for, then press return/enter).  Find the next one by using the `n` command.  Find the previous one by using the `N` commmand

**Hint**: Use `less` with the `/` command, `n` command, and the `N` commmand

### Exercise 0.3: Search for a string using less
Print the contents of the `Test File 1.md` file.  Notice that the file has spaces in the name.

**Hint**: Use `cat`.  Try surrounding the filename with single-quotes, or with double-quotes, or by putting a backslash ( `\`) before each of the spaces

---

## Part 1: Finding Files with `find`

### Exercise 1.1: Basic File Search
Find all Java source files in the project.

**Hint**: Use `-name` with a wildcard pattern.

### Exercise 1.2: Find by Type
Find all directories within the project.

**Hint**: Use the `-type` option.

### Exercise 1.3: Find Recent Files
Find all files that were modified in the last 10 minutes.

**Hint**: Use `-mmin` option.

### Exercise 1.4: Find Empty Files
Find any empty files in the logs directory (if any exist).

**Hint**: Use `-empty` option.

### Exercise 1.5: Find by Size
Find all files larger than 1KB.

**Hint**: Use `-size` option with `+1k`.

### Exercise 1.6: Complex Search
Find all `.java` files that are in test directories (hint: path contains "test").

**Hint**: Combine `-name` with `-path`.

---

## Part 2: Searching File Contents with `grep`

### Exercise 2.1: Simple Pattern Search
Find all occurrences of "TODO" in Java files.

**Hint**: Use `grep -r` for recursive search.

### Exercise 2.2: Case-Insensitive Search
Find all occurrences of "error" (case-insensitive) in log files.

**Hint**: Use the `-i` flag.

### Exercise 2.3: Count Matches
Count how many times "User" appears in all Java files.

**Hint**: Use the `-c` flag, or pipe to `wc -l`.

### Exercise 2.4: Show Line Numbers
Find all "BUG" comments in Java files and show the line numbers.

**Hint**: Use the `-n` flag.

### Exercise 2.5: Context Lines
Find all "ERROR" entries in logs, showing 2 lines before and after each match.

**Hint**: Use `-A` and `-B` flags, or `-C` for context.

### Exercise 2.6: Multiple Patterns
Find lines that contain either "TODO" or "FIXME" in Java files.

**Hint**: Use the `-E` flag with alternation `|`, or use `grep -e`.

### Exercise 2.7: Invert Match
Find all lines in `app.log` that do NOT contain "INFO".

**Hint**: Use the `-v` flag.

### Exercise 2.8: Files with Matches Only
List only the filenames of Java files that contain the word "public".

**Hint**: Use the `-l` flag.

---

## Part 3: Combining `find` and `grep`

### Exercise 3.1: Find and Grep
Find all `.properties` files and search them for "password".

**Hint**: Use `find` with `-exec grep` or pipe to `xargs grep`.

### Exercise 3.2: Find Recent Logs
Find log files modified in the last day and search them for "ERROR".

**Hint**: Combine `find -mtime` with `grep`.

### Exercise 3.3: Count TODO Comments
Count the total number of TODO comments across all Java source files.

**Hint**: Use `find`, `xargs`, and `wc -l`.

---

## Part 4: Looping Over Files

### Exercise 4.1: Simple Loop
Write a loop that prints the name of each `.log` file in the logs directory.

**Hint**: Use a `for` loop with a glob pattern.

```bash
for file in logs/*.log; do
    # Your code here
done
```

### Exercise 4.2: File Size Report
Create a loop that prints each CSV file name along with its size.

**Hint**: Use `ls -lh` or `du -h` inside the loop.

### Exercise 4.3: Line Count Summary
For each log file, print the filename and the number of lines it contains.

**Hint**: Use `wc -l` inside your loop.

### Exercise 4.4: Error Summary by File
Loop through all log files and print each filename followed by the count of ERROR lines in that file.

**Hint**: Combine looping with `grep -c`.

### Exercise 4.5: Conditional Processing
Loop through all CSV files. For each file, print "Large file: [filename]" if it has more than 10 lines, or "Small file: [filename]" otherwise.

**Hint**: Use `wc -l` with an `if` statement inside your loop.

### Exercise 4.6: Batch File Processing
Loop through all Java files in the `src/main/java` directory and count how many contain the word "TODO". Print a summary at the end.

**Hint**: Use a counter variable that increments when grep finds a match.

---

## Part 5: Advanced Combinations

### Exercise 5.1: Find and Process
Write a script that:
1. Finds all Java test files (in test directories)
2. For each test file, prints the filename and the number of @Test annotations

**Hint**: Use `find` with a while loop reading from a pipe.

### Exercise 5.2: Log Analysis
Write a script that analyzes `app.log` and creates a summary showing the count of each log level (INFO, ERROR, WARN, DEBUG).

**Hint**: Use `grep -c` multiple times or `grep | sort | uniq -c`.

### Exercise 5.3: Performance Report
From `performance.log`, find all requests that took longer than 1000ms and save them to a file called `slow_requests.txt`.

**Hint**: Use `grep` with a pattern that matches 4+ digit milliseconds, then redirect output.

### Exercise 5.4: CSV Column Extraction
Extract only the `name` and `price` columns from `products.csv` (columns 2 and 4).

**Hint**: Use `cut` command with `-d` delimiter and `-f` fields.

### Exercise 5.5: Find Unused Products
Compare `products.csv` with `orders.csv` to find product IDs that exist in products but never appear in orders.

**Hint**: This is challenging! Consider using `grep -v -f` or `comm` after sorting.

### Exercise 5.6: Configuration Audit
Find all `.properties` files and check each one for any uncommented lines containing "password" or "secret". Print the filename and line for each match.

**Hint**: Combine `find`, `grep` with multiple patterns, and exclude comment lines.

### Exercise 5.7: Recursive File Counter
Write a script that counts how many files of each extension exist in the entire project. Output should look like:
```
.java: 6
.log: 4
.csv: 3
```

**Hint**: Use `find`, extract extensions, then `sort | uniq -c`.

---

## Part 6: Real-World Scenarios

### Exercise 6.1: Code Review Helper
Create a command that finds all Java files with "BUG", "TODO", or "FIXME" comments and generates a report showing the filename and line number of each.

### Exercise 6.2: Log Rotation Check
Write a script that checks all log files and warns if any are larger than 10KB.

**Hint**: Use `find -size` or check size in a loop with `du`.

### Exercise 6.3: Dependency Finder
Search all Java files for imports from specific packages (e.g., "com.example.models") and list which files use them.

**Hint**: Use `grep -r` with the import pattern.

### Exercise 6.4: API Endpoint Extractor
Extract all API endpoints from `docs/API.txt` that use the GET method.

**Hint**: Use `grep` to find lines with "GET /".

### Exercise 6.5: User Activity Report
From `app.log`, create a list of all unique usernames that logged in.

**Hint**: Use `grep` to find login lines, then extract usernames with `cut` or `awk`, and use `sort -u`.

### Exercise 6.6: Configuration Comparison
List all property names that appear in `app.properties` but NOT in `database.properties`.

**Hint**: Extract property names (before `=`), then use `grep -v -f` or `comm`.

---

## Challenge Exercises

### Challenge 1: Complete Log Parser
Write a script that:
- Processes all log files
- Counts total lines, ERROR lines, and WARN lines
- Identifies the most common error message
- Outputs a formatted summary report

### Challenge 2: Code Quality Report
Create a comprehensive report showing:
- Total lines of Java code (excluding comments and blank lines)
- Number of TODO/FIXME/BUG comments by file
- Files with no test coverage (Java files in `main` with no corresponding test file)

### Challenge 3: Data Pipeline
Build a pipeline that:
1. Extracts all "Electronics" products from `products.csv`
2. Finds their corresponding orders in `orders.csv`
3. Calculates the total revenue from electronics
4. Outputs the result

**Hint**: This requires `grep`, `cut`, `awk`, and possibly `bc` for calculations.

---

## Tips for Success

1. **Start Simple**: Test your commands with small patterns first
2. **Use `echo` for Debugging**: In loops, print what you're doing before doing it
3. **Read Error Messages**: They often tell you exactly what's wrong
4. **Build Incrementally**: Test each part of a complex command separately
5. **Check the Manual**: Use `man find`, `man grep`, etc. for detailed options
6. **Quote Your Strings**: Use quotes around patterns with spaces or special characters

---

## Learning Objectives

By completing these exercises, you will:
- Master finding files by name, type, size, and modification time
- Search file contents efficiently with various `grep` options
- Combine `find` and `grep` for powerful file system searches
- Loop over files to perform batch operations
- Process and analyze log files and CSV data
- Build real-world scripts for code and data analysis

Good luck!
