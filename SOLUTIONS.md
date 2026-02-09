# Command Line Practice Solutions

Complete solutions to the exercises. Try to solve them yourself first!

---

## Part 0: Examining File Contents

### Exercise 0.1: Print out the contents of a file

```bash
cat EXERCISES.md
```

### Exercise 0.2: Display the contents of a file using a terminal 'pager' program

```bash
less EXERCISES.md
```

Once in `less`:

- Use arrow keys, PageUp/PageDown to navigate
- Press `j` to move down one line (just like Vim)
- Press `k` to move up one line (just like Vim)
- Press `q` to quit

### Exercise 0.3: Search for a string using less

```bash
less EXERCISES.md
```

Then while in `less`:

- Type `/###` and press Enter to search forward for level 3 headers
- Press `n` to go to the next match
- Press `N` (Shift+n) to go to the previous match
- Press `q` to quit

### Exercise 0.4: Print a file with spaces in the name

```bash
# Method 1: Single quotes
cat 'Test File 1.md'

# Method 2: Double quotes
cat "Test File 1.md"

# Method 3: Backslash escaping
cat Test\ File\ 1.md
```

Note: All three methods work equally well. Quoting is generally preferred for readability.

---

## Part 1: Finding Files with `find`

### Exercise 1.1: Basic File Search
```bash
find . -name "*.java"
```

### Exercise 1.2: Find by Type
```bash
find . -type d
```

### Exercise 1.3: Find Recent Files
```bash
find . -mmin -10
```

### Exercise 1.4: Find Empty Files
```bash
find logs -empty
```

### Exercise 1.5: Find by Size
```bash
find . -size +1k
```

### Exercise 1.6: Complex Search
```bash
find . -path "*/test/*" -name "*.java"
# Or
find . -name "*.java" | grep test
```

---

## Part 2: Searching File Contents with `grep`

### Exercise 2.1: Simple Pattern Search
```bash
grep -r "TODO" --include="*.java" .
# Or
grep -r "TODO" *.java
```

### Exercise 2.2: Case-Insensitive Search
```bash
grep -i "error" logs/*.log
```

### Exercise 2.3: Count Matches
```bash
# Count occurrences per file
grep -r "User" --include="*.java" -c .

# Total count across all files
grep -r "User" --include="*.java" . | wc -l
```

### Exercise 2.4: Show Line Numbers
```bash
grep -rn "BUG" --include="*.java" .
```

### Exercise 2.5: Context Lines
```bash
grep -C 2 "ERROR" logs/*.log
# Or separately:
grep -B 2 -A 2 "ERROR" logs/*.log
```

### Exercise 2.6: Multiple Patterns
```bash
grep -rE "TODO|FIXME" --include="*.java" .
# Or
grep -re "TODO" -e "FIXME" --include="*.java" .
```

### Exercise 2.7: Invert Match
```bash
grep -v "INFO" logs/app.log
```

### Exercise 2.8: Files with Matches Only
```bash
grep -rl "public" --include="*.java" .
```

---

## Part 3: Combining `find` and `grep`

### Exercise 3.1: Find and Grep
```bash
# Using -exec
find . -name "*.properties" -exec grep "password" {} +

# Using xargs (preferred for better performance)
find . -name "*.properties" | xargs grep "password"

# Using xargs with null delimiter (handles special characters)
find . -name "*.properties" -print0 | xargs -0 grep "password"
```

### Exercise 3.2: Find Recent Logs
```bash
find logs -name "*.log" -mtime -1 -exec grep "ERROR" {} +
# Or
find logs -name "*.log" -mtime -1 | xargs grep "ERROR"
```

### Exercise 3.3: Count TODO Comments
```bash
find src -name "*.java" -exec grep "TODO" {} \; | wc -l
# Or
find src -name "*.java" | xargs grep "TODO" | wc -l
```

---

## Part 4: Looping Over Files

### Exercise 4.1: Simple Loop
```bash
for file in logs/*.log; do
    echo "$file"
done
```

### Exercise 4.2: File Size Report
```bash
for file in data/*.csv; do
    size=$(du -h "$file" | cut -f1)
    echo "$file: $size"
done

# Or using ls
for file in data/*.csv; do
    ls -lh "$file" | awk '{print $9": "$5}'
done
```

### Exercise 4.3: Line Count Summary
```bash
for file in logs/*.log; do
    lines=$(wc -l < "$file")
    echo "$file: $lines lines"
done
```

### Exercise 4.4: Error Summary by File
```bash
for file in logs/*.log; do
    count=$(grep -c "ERROR" "$file" || echo 0)
    echo "$file: $count errors"
done
```

### Exercise 4.5: Conditional Processing
```bash
for file in data/*.csv; do
    lines=$(wc -l < "$file")
    if [ "$lines" -gt 10 ]; then
        echo "Large file: $file"
    else
        echo "Small file: $file"
    fi
done
```

### Exercise 4.6: Batch File Processing
```bash
count=0
for file in src/main/java/*.java; do
    if grep -q "TODO" "$file"; then
        count=$((count + 1))
    fi
done
echo "Files with TODO: $count"
```

---

## Part 5: Advanced Combinations

### Exercise 5.1: Find and Process
```bash
# Method 1: Using while read
find . -path "*/test/*" -name "*.java" | while read -r file; do
    num_tests=$(grep -c "@Test" "$file" || echo 0)
    echo "$file: $num_tests tests"
done

# Method 2: Using for loop
for file in $(find . -path "*/test/*" -name "*.java"); do
    num_tests=$(grep -c "@Test" "$file" || echo 0)
    echo "$file: $num_tests tests"
done
```

### Exercise 5.2: Log Analysis
```bash
# Method 1: Multiple grep commands
echo "INFO: $(grep -c 'INFO' logs/app.log)"
echo "ERROR: $(grep -c 'ERROR' logs/app.log)"
echo "WARN: $(grep -c 'WARN' logs/app.log)"
echo "DEBUG: $(grep -c 'DEBUG' logs/app.log)"

# Method 2: Extract and count
grep -oE 'INFO|ERROR|WARN|DEBUG' logs/app.log | sort | uniq -c
```

### Exercise 5.3: Performance Report
```bash
grep -E 'duration=[0-9]{4,}ms' logs/performance.log > slow_requests.txt

# Or more specifically, requests > 1000ms
awk -F'duration=' '$2 >= 1000' logs/performance.log > slow_requests.txt
```

### Exercise 5.4: CSV Column Extraction
```bash
cut -d',' -f2,4 data/products.csv
```

### Exercise 5.5: Find Unused Products
```bash
# Method 1: Compare sorted lists
cut -d',' -f1 data/products.csv | tail -n +2 | sort > /tmp/all_products.txt
cut -d',' -f3 data/orders.csv | tail -n +2 | sort | uniq > /tmp/ordered_products.txt
comm -23 /tmp/all_products.txt /tmp/ordered_products.txt

# Method 2: Using grep
for product in $(cut -d',' -f1 data/products.csv | tail -n +2); do
    if ! grep -q "$product" data/orders.csv; then
        echo "$product"
    fi
done
```

### Exercise 5.6: Configuration Audit
```bash
find config -name "*.properties" -exec grep -HnE "password|secret" {} \; | grep -v "^#"

# Or more explicitly filtering comments
find config -name "*.properties" | while read -r file; do
    grep -nE "password|secret" "$file" | grep -v "^[0-9]*:#"
done
```

### Exercise 5.7: Recursive File Counter
```bash
# Method 1: Using find and awk
find . -type f | sed 's/.*\./\./' | sort | uniq -c | sort -rn

# Method 2: More explicit
find . -type f -name "*.*" | awk -F. '{print $NF}' | sort | uniq -c | awk '{print "."$2": "$1}'

# Method 3: Simple approach
for ext in $(find . -type f -name "*.*" | sed 's/.*\././' | sort -u); do
    count=$(find . -type f -name "*$ext" | wc -l)
    echo "$ext: $count"
done
```

---

## Part 6: Real-World Scenarios

### Exercise 6.1: Code Review Helper
```bash
grep -rnE "BUG|TODO|FIXME" --include="*.java" . --color=always

# Or with better formatting
echo "=== Code Review Report ==="
grep -rnE "BUG|TODO|FIXME" --include="*.java" . | while IFS=: read -r file line content; do
    echo "File: $file"
    echo "Line: $line"
    echo "Content: $content"
    echo "---"
done
```

### Exercise 6.2: Log Rotation Check
```bash
# Method 1: Using find
find logs -name "*.log" -size +10k -exec echo "WARNING: {} is larger than 10KB" \;

# Method 2: Using loop
for file in logs/*.log; do
    size=$(du -k "$file" | cut -f1)
    if [ "$size" -gt 10 ]; then
        echo "WARNING: $file is ${size}KB (larger than 10KB)"
    fi
done
```

### Exercise 6.3: Dependency Finder
```bash
grep -r "import com.example.models" --include="*.java" -l .

# With more detail
grep -rn "import com.example.models" --include="*.java" .
```

### Exercise 6.4: API Endpoint Extractor
```bash
grep "^GET" docs/API.txt

# Or more specifically
grep "GET /api" docs/API.txt
```

### Exercise 6.5: User Activity Report
```bash
grep "User login" logs/app.log | cut -d'=' -f2 | sort -u

# Alternative using awk
grep "User login" logs/app.log | awk -F'username=' '{print $2}' | sort -u
```

### Exercise 6.6: Configuration Comparison
```bash
# Extract property names and compare
grep -v "^#" config/app.properties | cut -d'=' -f1 | sort > /tmp/app_props.txt
grep -v "^#" config/database.properties | cut -d'=' -f1 | sort > /tmp/db_props.txt
comm -23 /tmp/app_props.txt /tmp/db_props.txt

# Cleanup
rm /tmp/app_props.txt /tmp/db_props.txt
```

---

## Challenge Exercises

### Challenge 1: Complete Log Parser
```bash
#!/bin/bash

echo "=== Log Analysis Report ==="
echo

total_lines=0
total_errors=0
total_warns=0

for file in logs/*.log; do
    lines=$(wc -l < "$file")
    errors=$(grep -c "ERROR" "$file" || echo 0)
    warns=$(grep -c "WARN" "$file" || echo 0)

    total_lines=$((total_lines + lines))
    total_errors=$((total_errors + errors))
    total_warns=$((total_warns + warns))

    echo "File: $file"
    echo "  Lines: $lines"
    echo "  Errors: $errors"
    echo "  Warnings: $warns"
    echo
done

echo "=== Summary ==="
echo "Total lines: $total_lines"
echo "Total errors: $total_errors"
echo "Total warnings: $total_warns"
echo

echo "=== Most Common Errors ==="
grep "ERROR" logs/*.log | awk -F'ERROR' '{print $2}' | sort | uniq -c | sort -rn | head -5
```

### Challenge 2: Code Quality Report
```bash
#!/bin/bash

echo "=== Code Quality Report ==="
echo

# Total lines of Java code (excluding comments and blank lines)
total_lines=$(find src -name "*.java" -exec cat {} \; | grep -v "^\s*$" | grep -v "^\s*\/\/" | grep -v "^\s*\*" | wc -l)
echo "Total lines of Java code: $total_lines"
echo

# TODO/FIXME/BUG comments by file
echo "=== TODO/FIXME/BUG Comments ==="
for file in $(find src -name "*.java"); do
    count=$(grep -cE "TODO|FIXME|BUG" "$file" || echo 0)
    if [ "$count" -gt 0 ]; then
        echo "$file: $count"
    fi
done
echo

# Files with no test coverage
echo "=== Files Without Tests ==="
for file in $(find src/main/java -name "*.java"); do
    basename=$(basename "$file" .java)
    test_file="src/test/java/${basename}Test.java"
    if [ ! -f "$test_file" ]; then
        echo "$file (missing $test_file)"
    fi
done
```

### Challenge 3: Data Pipeline
```bash
#!/bin/bash

# Extract Electronics products
electronics=$(grep "Electronics" data/products.csv | cut -d',' -f1)

echo "=== Electronics Revenue Report ==="
echo "Electronics Products:"
echo "$electronics"
echo

total_revenue=0

# For each electronics product, find orders and sum revenue
for product_id in $electronics; do
    # Find matching orders and sum the total column
    revenue=$(grep "$product_id" data/orders.csv | grep "completed" | cut -d',' -f5 | paste -sd+ | bc)

    if [ -n "$revenue" ]; then
        product_name=$(grep "$product_id" data/products.csv | cut -d',' -f2)
        echo "$product_name ($product_id): \$$revenue"
        total_revenue=$(echo "$total_revenue + $revenue" | bc)
    fi
done

echo
echo "Total Electronics Revenue: \$$total_revenue"
```

---

## Additional Tips

### Working with Special Characters in Filenames
```bash
# Always quote variables
for file in *.log; do
    echo "$file"  # Good
    echo $file    # Bad - breaks on spaces
done

# Use while read for find output
find . -name "*.java" -print0 | while IFS= read -r -d '' file; do
    echo "$file"
done
```

### Testing Before Executing
```bash
# Add echo to test destructive commands
for file in *.log; do
    echo rm "$file"  # Test first
    # rm "$file"     # Execute after confirming
done
```

### Using grep Options Effectively
```bash
# Recursive search with file type filter
grep -r "pattern" --include="*.java" .

# Exclude directories
grep -r "pattern" --exclude-dir=".git" .

# Show only matching part
grep -o "pattern" file.txt

# Count matches per file
grep -c "pattern" *.txt
```

### Combining Commands with Pipes
```bash
# Extract, sort, and count unique values
grep "ERROR" logs/*.log | cut -d' ' -f5 | sort | uniq -c | sort -rn

# Find, filter, and process
find . -name "*.java" | grep -v test | xargs wc -l | sort -n
```

---

## Common Pitfalls and How to Avoid Them

1. **Forgetting to quote variables**: Always use `"$variable"`
2. **Not handling files with spaces**: Use `-print0` with `xargs -0`
3. **Assuming grep matches exist**: Use `|| echo 0` with `grep -c`
4. **Forgetting headers in CSV files**: Use `tail -n +2` to skip header
5. **Not escaping special regex characters**: Use `\` or `grep -F` for literal matches

---

Good luck with your exercises!


---
IGNORE THE FOLLOWING:
Minor change for temp1 branch
Another small change