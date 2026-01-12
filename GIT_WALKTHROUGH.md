# Git Practice Exercises

These exercises will teach you the fundamentals of Git version control using command-line git. This is solo Git practice - no branching or pull requests yet!

## Prerequisites

- Git installed on your system
- A GitHub account (you'll need this for Part 4)
- Command line terminal access

---

## Part 1: Local Git Basics

In this section, you'll practice initializing a repository and making commits locally.

### Setup: Create a Practice Directory

First, create a new directory for practicing Git basics (separate from the Command_Line_Practice repo):

```bash
cd ~
mkdir git_practice_local
cd git_practice_local
```

### Exercise 1.1: Initialize a Git Repository

Initialize this directory as a Git repository.

**Command to use**: `git init`

**After running the command**:
- Run `ls -la` to see the hidden `.git` directory that was created
- Run `git status` to see the current state

**Question**: What does `git status` tell you?

---

### Exercise 1.2: Create Your First File

Create a simple text file and check its status:

```bash
echo "# My Git Practice" > README.md
git status
```

**Questions**:
1. What color is the filename in the output?
2. What does Git say about this file?
3. Is this file tracked or untracked?

---

### Exercise 1.3: Stage Your First File

Add the file to the staging area (also called the "index"):

```bash
git add README.md
git status
```

**Questions**:
1. What color is the filename now?
2. What changed in the git status output?
3. What does "Changes to be committed" mean?

---

### Exercise 1.4: Make Your First Commit

Commit the staged changes:

```bash
git commit -m "Initial commit: add README"
git status
```

**Questions**:
1. What does `git status` say now?
2. What does "working tree clean" mean?

---

### Exercise 1.5: View Commit History

Look at your commit history:

```bash
git log
```

**Questions**:
1. What information does `git log` show you?
2. What is that long string of letters and numbers (the commit hash)?
3. Who is listed as the author?

---

### Exercise 1.6: Make a Change and Commit It

Now let's practice the modify-stage-commit cycle:

```bash
echo "This is my practice repository for learning Git." >> README.md
git status
```

**Notice**: The file shows as "modified"

```bash
git add README.md
git status
```

**Notice**: Now it says "Changes to be committed"

```bash
git commit -m "Add description to README"
git status
git log
```

**Questions**:
1. How many commits do you now have?
2. What's the commit message for each?

---

### Exercise 1.7: Multiple Files, One Commit

Create several files and commit them together:

```bash
echo "First file" > file1.txt
echo "Second file" > file2.txt
echo "Third file" > file3.txt
git status
```

**Question**: How many untracked files do you see?

```bash
git add file1.txt file2.txt file3.txt
git status
git commit -m "Add three text files"
git log --oneline
```

**Note**: `--oneline` shows a condensed version of the log

---

### Exercise 1.8: The Add-All Shortcut

Create more files and use `git add .` to stage everything:

```bash
echo "Notes about Git" > notes.txt
echo "Todo list" > todo.txt
git status
git add .
git status
git commit -m "Add notes and todo files"
git log --oneline
```

**Question**: How is `git add .` different from `git add <filename>`?

---

### Exercise 1.9: Viewing Changes Before Staging

Make a change but DON'T stage it yet:

```bash
echo "Git tracks changes to files" >> notes.txt
git status
git diff
```

**Questions**:
1. What does `git diff` show you?
2. What do the `+` and `-` symbols mean?
3. What color are the changes?

Now stage and commit:

```bash
git add notes.txt
git diff
git diff --staged
git commit -m "Update notes with Git information"
```

**Questions**:
1. Why did `git diff` show nothing after staging?
2. What command shows staged changes?

---

## Part 2: Viewing History and the Commit Graph

### Exercise 2.1: View Compact Log

View your history in a compact format:

```bash
git log --oneline
```

**Question**: What information is shown for each commit?

---

### Exercise 2.2: View the Commit Graph

View your commits as a graph:

```bash
git log --oneline --graph --all
```

**Questions**:
1. Does your graph look like a straight line or have branches?
2. Why does it look this way? (Hint: Have you made any branches yet?)

---

### Exercise 2.3: View Detailed Commit Information

Look at a specific commit in detail:

```bash
git show HEAD
```

**Questions**:
1. What does `HEAD` refer to?
2. What information does `git show` display?

---

### Exercise 2.4: Interactive Learning - Learn Git Branching

Now that you've seen the commit graph in the terminal, let's visualize it better!

**Go to**: [https://learngitbranching.js.org/](https://learngitbranching.js.org/)

**Complete**: Only the first level: "Introduction Sequence's first exercise: Introduction to Git Commits"

This interactive tutorial will show you:
- How commits form a graph structure
- How each commit points to its parent
- A visual representation of what you've been doing

**After completing the level**: Return to these exercises!

---

## Part 3: Time Travel - Working with Detached HEAD

### Exercise 3.1: View Your Commit History

First, let's see all your commits:

```bash
git log --oneline
```

**Task**: Choose the commit hash of your SECOND commit (not the most recent one, but the one before it)

---

### Exercise 3.2: Checkout an Earlier Commit

Checkout that earlier commit (replace `<commit-hash>` with your actual hash):

```bash
git checkout <commit-hash>
```

**Example**:
```bash
git checkout a1b2c3d
```

**Questions**:
1. What warning message does Git give you?
2. What does "detached HEAD state" mean?

---

### Exercise 3.3: Explore the Detached HEAD State

Look around at your files:

```bash
ls
cat README.md
```

**Questions**:
1. Do you see all the files you created?
2. What happened to files created in later commits?

View the log:

```bash
git log --oneline
```

**Question**: Do you see your most recent commits in the log?

---

### Exercise 3.4: Understanding Detached HEAD

**Detached HEAD Explanation**:

When you checkout a specific commit (instead of a branch), you enter "detached HEAD" state. This means:
- `HEAD` points directly to a commit instead of a branch
- You're viewing the repository as it existed at that point in time
- You can look around, but you shouldn't make new commits here (yet - you'll learn about that when you learn about branches)

**Visual Concept**:
```
Normal:  HEAD -> main -> commit3
                          ↓
                        commit2
                          ↓
                        commit1

Detached: HEAD -> commit2
                    ↓
                  commit1
```

---

### Exercise 3.5: Return to the Present

Go back to your most recent commit:

```bash
git checkout main
```

**Note**: If Git says you don't have a `main` branch, try `git checkout master`

Check your files:

```bash
ls
cat README.md
git log --oneline
```

**Questions**:
1. Are all your files back?
2. Do you see all your commits in the log now?

---

### Exercise 3.6: Practice Time Travel Again

1. View your log: `git log --oneline`
2. Pick a different earlier commit
3. Checkout that commit: `git checkout <commit-hash>`
4. Look around: `ls`, `cat` some files
5. Return to main: `git checkout main`

**Reflection**: Describe in your own words what "detached HEAD" means and why it might be useful.

---

## Part 4: GitHub Integration - Remote Repositories

Now you'll learn how to use GitHub as a remote backup for your code!

### Exercise 4.1: Create a GitHub Repository

1. Go to [https://github.com](https://github.com)
2. Log in to your account
3. Click the "+" icon in the top right
4. Select "New repository"
5. Name it: `git-practice-local` (or whatever you'd like)
6. Description: "Practice repository for learning Git"
7. Keep it **Public**
8. Do **NOT** check "Initialize this repository with a README"
9. Click "Create repository"

**Question**: Why should you NOT initialize with a README for this exercise?

---

### Exercise 4.2: Connect Your Local Repo to GitHub

GitHub will show you instructions. Follow the section "push an existing repository from the command line":

```bash
git remote add origin https://github.com/YOUR-USERNAME/git-practice-local.git
git branch -M main
git push -u origin main
```

**Replace** `YOUR-USERNAME` with your actual GitHub username!

**Questions**:
1. What does `git remote add origin` do?
2. What does `origin` refer to?
3. What did `git push` do?

---

### Exercise 4.3: Verify on GitHub

Refresh your GitHub repository page in your browser.

**Questions**:
1. Do you see all your files?
2. Do you see your commit messages?
3. Click on "commits" - what do you see?

---

### Exercise 4.4: Make Local Changes and Push

Make a change locally and push it to GitHub:

```bash
echo "GitHub integration is working!" >> README.md
git status
git add README.md
git commit -m "Confirm GitHub integration"
git push
```

**Note**: You don't need `-u origin main` anymore after the first push!

Refresh GitHub - do you see the new commit?

---

### Exercise 4.5: Make Changes on GitHub

Now let's make a change ON GitHub and pull it down:

1. On GitHub, click on `README.md`
2. Click the pencil icon (Edit this file)
3. Add a new line: "This change was made on GitHub!"
4. Scroll down to "Commit changes"
5. Add commit message: "Edit README on GitHub"
6. Click "Commit changes"

**Question**: How is editing on GitHub different from editing locally?

---

### Exercise 4.6: Pull Changes from GitHub

Back in your terminal:

```bash
git status
```

**Question**: Does Git know about your GitHub changes yet?

```bash
git pull
cat README.md
git log --oneline
```

**Questions**:
1. Do you see the changes you made on GitHub?
2. Do you see the commit in your log?

---

### Exercise 4.7: The Complete Cycle

Practice the complete workflow:

1. Edit a file locally: `echo "Local change" >> notes.txt`
2. Stage: `git add notes.txt`
3. Commit: `git commit -m "Add local note"`
4. Push: `git push`
5. Verify on GitHub in browser
6. Edit a different file on GitHub (edit `todo.txt`)
7. Pull: `git pull`
8. Verify locally: `cat todo.txt`

---

## Part 5: Clone a Repository (Fresh Start)

### Exercise 5.1: Clone the Course Repository

Now let's practice cloning an existing repository. Open a new terminal and navigate to a different directory:

```bash
cd ~
mkdir course_repos
cd course_repos
```

Clone the Command_Line_Practice repository:

```bash
git clone https://github.com/MikeTheGreat/Command_Line_Practice.git
cd Command_Line_Practice
```

**Questions**:
1. What files and directories were created?
2. Did you need to run `git init`? Why not?

---

### Exercise 5.2: Explore the Cloned Repository

```bash
git status
git log --oneline --graph --all
git remote -v
```

**Questions**:
1. What is the remote called?
2. What URL does it point to?
3. Can you push to this repository? (Try `git push` and see what happens)

---

### Exercise 5.3: Make Local Commits (Without Pushing)

Even though you can't push to someone else's repository, you can make local commits:

```bash
echo "My personal notes" > MY_NOTES.md
git add MY_NOTES.md
git commit -m "Add my personal notes"
git log --oneline
```

**Question**: Is this commit on GitHub? (Check the repository page)

**This demonstrates**: You can use Git locally for version control even without pushing to a remote!

---

## Part 6: Visual Understanding - Drawing Diagrams

### Exercise 6.1: Draw the Git Workflow

On paper (or in a drawing tool), draw a diagram showing the Git workflow:

**Include these elements**:
1. Working Directory
2. Staging Area (Index)
3. Local Repository
4. Remote Repository (GitHub)

**Show these actions with arrows**:
- `git add` (Working → Staging)
- `git commit` (Staging → Local Repo)
- `git push` (Local Repo → Remote)
- `git pull` (Remote → Local Repo → Working Directory)
- `git clone` (Remote → everything)

**Reference**: Look back at the `learngitbranching.js.org` visualizations to help!

---

### Exercise 6.2: Draw Your Commit History

On paper, draw your commit history from `git_practice_local`:

**Show**:
1. Each commit as a circle or box
2. The commit message
3. Arrows pointing from each commit to its parent
4. Where `HEAD` is pointing
5. Where `main` branch is pointing

**Reference**: Use `git log --oneline --graph --all` to help

---

### Exercise 6.3: Draw Detached HEAD State

Draw TWO diagrams:

**Diagram 1**: Normal state with HEAD pointing to main branch
**Diagram 2**: Detached HEAD state when you checked out an earlier commit

**Show the difference** between:
- `HEAD -> main -> commit`
- `HEAD -> commit` (detached)

---

## Part 7: Reflection Questions

Answer these questions in a text file (you can create it in your `git_practice_local` repo!):

### Question 1: Mental Model
Explain in your own words what each of these represents:
- Working Directory
- Staging Area
- Local Repository
- Remote Repository

### Question 2: Common Commands
Describe what each command does:
- `git status`
- `git add`
- `git commit`
- `git log`
- `git push`
- `git pull`

### Question 3: GitHub as Backup
How would you use GitHub as a personal backup solution? Describe the workflow for:
1. Setting up a new project
2. Regularly backing up your work
3. Recovering your work on a different computer

### Question 4: Detached HEAD
What is a "detached HEAD" state? When might you want to checkout an old commit?

### Question 5: Commit Messages
Why are good commit messages important? What makes a commit message good vs. bad?

---

## Summary: Commands You've Learned

### Repository Setup
- `git init` - Initialize a new Git repository
- `git clone <url>` - Clone an existing repository

### Basic Workflow
- `git status` - Check the status of your working directory
- `git add <file>` - Stage a file for commit
- `git add .` - Stage all changed files
- `git commit -m "message"` - Commit staged changes
- `git log` - View commit history
- `git log --oneline` - View compact commit history
- `git log --oneline --graph --all` - View commit graph

### Examining Changes
- `git diff` - See unstaged changes
- `git diff --staged` - See staged changes
- `git show <commit>` - Show a specific commit

### Time Travel
- `git checkout <commit-hash>` - Go to a specific commit (detached HEAD)
- `git checkout main` - Return to the main branch

### Remote Operations
- `git remote add origin <url>` - Connect to a remote repository
- `git push` - Send commits to remote
- `git pull` - Get commits from remote

---

## Next Steps

You've learned the fundamentals of solo Git usage! In future classes, you'll learn:
- Branching and merging
- Pull requests and code review
- Handling merge conflicts
- Team collaboration workflows

Great work!
