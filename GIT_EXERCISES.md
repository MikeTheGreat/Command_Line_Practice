# Git Practice Exercises

These exercises will teach you the fundamentals of Git version control using command-line git. This is solo Git practice - no branching or pull requests yet!

**Important**: These exercises ask you to figure out what commands to use. If you get stuck, check [GIT_WALKTHROUGH.md](GIT_WALKTHROUGH.md) or [GIT_SOLUTIONS.md](GIT_SOLUTIONS.md) for help!

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

---

### Exercise 1.1: Initialize a Git Repository

Your new `git_practice_local` directory is just a regular folder right now. Make it into a Git repository.

**Your task**: Figure out which Git command initializes a new repository.

**After running the command**:
- Use `ls -la` to verify that a hidden `.git` directory was created
- Check the current state of your repository

**Questions**:
1. What does the status command tell you about your repository?
2. What branch are you on?

---

### Exercise 1.2: Create Your First File

Create a file called `README.md` with the text "# My Git Practice" in it.

**Your task**:
1. Create the file (you can use `echo` with `>` redirection)
2. Check the status of your repository

**Questions**:
1. What color is the filename in the output?
2. What does Git say about this file?
3. Is this file in your working tree, staging area (index), or local repository?

---

### Exercise 1.3: Stage Your First File

Git knows about your README.md file, but it's not tracking it yet. You need to add it to the staging area.

**Your task**: Add `README.md` to the staging area (also called the "index"), then check the status.

**Questions**:
1. What color is the filename now?
2. How did the status output change?
3. Is the file now in the staging area (index)?
4. What does "Changes to be committed" mean?

---

### Exercise 1.4: Make Your First Commit

Now commit the staged changes with the message "Initial commit: add README"

**Your task**:
1. Make your first commit
2. Check the status afterward

**Questions**:
1. What does the status command say now?
2. What does "working tree clean" mean?
3. Where is your file now stored (working tree, staging area, or local repository)?

---

### Exercise 1.5: View Commit History

Look at your commit history to see the commit you just made.

**Your task**: Use the appropriate Git command to view the commit history.

**Questions**:
1. What information does this command show you?
2. What is that long string of letters and numbers (the commit hash)?
3. Who is listed as the author?

---

### Exercise 1.6: Make a Change and Commit It

Now let's practice the modify-stage-commit cycle:

1. Add a line to README.md: "This is my practice repository for learning Git."
2. Check the status

**Your task**: Complete the cycle to commit this change with message "Add description to README"

**Notice** what the status shows after each step:
- After modifying (what's in the working tree?)
- After staging (what's in the staging area/index?)
- After committing (is the working tree clean?)

**Questions**:
1. After modifying but before staging, what does Git call this file?
2. How many commits do you now have total?
3. What's the commit message for each?

---

### Exercise 1.7: Multiple Files, One Commit

**Your task**:
1. Create three files: `file1.txt`, `file2.txt`, and `file3.txt` (put any text you want in them)
2. Check the status - how many untracked files do you see?
3. Stage all three files
4. Commit them with message "Add three text files"
5. View the commit history in a condensed format (one line per commit)

**Hint for the last step**: Use `git log --oneline`

**Questions**:
1. How many files were in your working tree before staging?
2. How many files were in the staging area (index) before committing?
3. After the commit, how many commits are in your local repository?

---

### Exercise 1.8: The Add-All Shortcut

**Your task**:
1. Create two more files: `notes.txt` and `todo.txt` (with any content)
2. Check status
3. Stage ALL changed/new files using a shortcut (not by naming each file)
4. Check status again
5. Commit with message "Add notes and todo files"
6. View the condensed commit history

**Question**: What's the difference between staging individual files versus staging all files at once? When might each be useful?

---

### Exercise 1.9: Viewing Changes Before Staging

**Your task**:
1. Add a line to `notes.txt`: "Git tracks changes to files"
2. Check the status
3. View the exact changes you made (what lines were added/removed)
4. Now stage the file
5. Try to view changes again - what do you see?
6. View the *staged* changes
7. Commit with message "Update notes with Git information"

**Questions**:
1. What does the diff command show you before staging?
2. What do the `+` and `-` symbols mean?
3. Why does the regular diff command show nothing after staging?
4. What command shows staged changes?
5. At each step, think about: Is the change in the working tree, staging area (index), or local repository?

---

## Part 2: Viewing History and the Commit Graph

### Exercise 2.1: View Compact Log

**Your task**: View your commit history in a compact format (one line per commit).

**Question**: What information is shown for each commit in this condensed view?

---

### Exercise 2.2: View the Commit Graph

**Your task**: View your commits as a graph using this command (we're showing you this one!):

```bash
git log --oneline --graph --all
```

**Questions**:
1. Does your graph look like a straight line or have branches?
2. Why does it look this way? (Hint: Have you made any branches yet?)
3. What would the graph look like if you had multiple branches?

---

### Exercise 2.3: View Detailed Commit Information

**Your task**: Show detailed information about your most recent commit (use `HEAD` to refer to it).

**Questions**:
1. What does `HEAD` refer to?
2. What information does this command display?
3. How is this different from viewing the log?

---

### Exercise 2.4: Interactive Learning - Learn Git Branching

Now that you've seen the commit graph in the terminal, let's visualize it better!

**Go to**: [https://learngitbranching.js.org/](https://learngitbranching.js.org/)

**Complete**: Only the first level: "Introduction Sequence's first exercise: Introduction to Git Commits"

This interactive tutorial will show you:
- How commits form a graph structure
- How each commit points to its parent
- A visual representation of the working tree → staging area → local repository flow

**After completing the level**: Return to these exercises!

---

## Part 3: Time Travel - Working with Detached HEAD

### Exercise 3.1: View Your Commit History

**Your task**:
1. View your commit history in condensed format
2. Pick the commit hash of your SECOND commit (not the most recent one, but the one before it)
3. Write down or copy that hash

---

### Exercise 3.2: Checkout an Earlier Commit

**Your task**: Checkout that earlier commit using its hash.

**Questions**:
1. What warning message does Git give you?
2. What does "detached HEAD state" mean?
3. In the normal state, HEAD points to a branch which points to a commit. What does HEAD point to now?

---

### Exercise 3.3: Explore the Detached HEAD State

**Your task**:
1. List the files in your directory
2. Look at the contents of README.md
3. View the commit history

**Questions**:
1. Do you see all the files you created in later commits?
2. What happened to files created after this commit?
3. Do you see your most recent commits in the log?
4. Think about the mental model: Which commit is your working tree showing now?

---

### Exercise 3.4: Understanding Detached HEAD

**Detached HEAD Explanation**:

When you checkout a specific commit (instead of a branch), you enter "detached HEAD" state. This means:
- `HEAD` points directly to a commit instead of to a branch
- Your working tree shows the repository as it existed at that point in time
- You can look around, but you shouldn't make new commits here (yet - you'll learn about that when you learn about branches)

**Visual Concept**:
```
Normal:  HEAD -> main -> commit3 -> commit2 -> commit1

Detached: HEAD -> commit2 -> commit1
          (main still points to commit3, but HEAD doesn't point to main)
```

---

### Exercise 3.5: Return to the Present

**Your task**: Return to your main branch (or master branch if that's what your default is called).

Then verify:
1. List your files
2. Look at README.md
3. View the commit history

**Questions**:
1. Are all your files back?
2. Do you see all your commits in the log now?
3. Where does HEAD point now?

---

### Exercise 3.6: Practice Time Travel Again

**Your task**:
1. View your commit history
2. Pick a different earlier commit
3. Checkout that commit
4. Look around at your files
5. Return to your main branch

**Reflection**: Write a few sentences explaining:
- What "detached HEAD" means
- Why it might be useful to checkout an old commit
- How this relates to the mental model of working tree → staging area → local repository

---

## Part 4: GitHub Integration - Remote Repositories

Now you'll learn how to use GitHub as a remote backup for your code!

### Exercise 4.1: Create a GitHub Repository

**Your task**:
1. Go to [https://github.com](https://github.com) and log in
2. Create a new repository
   - Name: `git-practice-local` (or your choice)
   - Description: "Practice repository for learning Git"
   - Public or Private (your choice)
   - Do **NOT** initialize with a README

**Question**: Why should you NOT initialize with a README for this exercise?

---

### Exercise 4.2: Connect Your Local Repository to GitHub

GitHub will show you instructions after creating the repo. Look for the section about pushing an existing repository.

**Your task**: Follow those instructions to:
1. Add GitHub as a remote called "origin"
2. Rename your branch to "main" if needed
3. Push your commits to GitHub

**Hints**:
- The commands will look like: `git remote add origin <url>`
- Then: `git branch -M main`
- Then: `git push -u origin main`

**Questions**:
1. What does the "remote add" command do?
2. What does "origin" refer to?
3. What did the push command do?
4. Think about the mental model: You've added a new location - the remote repository!

---

### Exercise 4.3: Verify on GitHub

**Your task**: Refresh your GitHub repository page in your browser.

**Questions**:
1. Do you see all your files?
2. Do you see your commit messages?
3. Click on "commits" - what do you see?
4. How does the GitHub view compare to `git log --oneline --graph`?

---

### Exercise 4.4: Make Local Changes and Push

**Your task**:
1. Add a line to README.md: "GitHub integration is working!"
2. Stage the change
3. Commit with message "Confirm GitHub integration"
4. Push to GitHub (you don't need the `-u origin main` flags this time)

**Then**: Refresh GitHub - do you see the new commit?

**Question**: In the mental model, what just happened? (working tree → staging area → local repository → ?)

---

### Exercise 4.5: Make Changes on GitHub

Now let's make a change ON GitHub's remote repository:

**Your task**:
1. On GitHub, click on `README.md`
2. Click the pencil icon (Edit this file)
3. Add a new line: "This change was made on GitHub!"
4. Commit the change (scroll down, add message "Edit README on GitHub", click Commit)

**Question**: How is editing on GitHub different from editing locally? Which repositories/areas are affected?

---

### Exercise 4.6: Pull Changes from GitHub

**Your task**:
1. Back in your terminal, check the status of your local repository
2. Pull the changes from GitHub
3. Look at README.md locally
4. View your commit history

**Questions**:
1. Before pulling, does your local Git know about the GitHub changes?
2. Do you see the changes you made on GitHub in your local file?
3. Do you see the commit in your local log?
4. In the mental model: remote repository → local repository → ? → ?

---

### Exercise 4.7: The Complete Cycle

**Your task**: Practice the complete workflow:

**Part A - Local to Remote**:
1. Add a line to `notes.txt`: "Local change"
2. Stage it
3. Commit it with message "Add local note"
4. Push to GitHub
5. Verify on GitHub in browser

**Part B - Remote to Local**:
1. Edit `todo.txt` directly on GitHub (add any line)
2. Commit on GitHub with message "Update todo on GitHub"
3. Pull the changes locally
4. Verify by viewing `todo.txt`

**Reflection**: Trace through the mental model for both directions:
- Working tree → staging area → local repository → remote repository
- Remote repository → local repository → working tree

---

## Part 5: Clone a Repository (Fresh Start)

### Exercise 5.1: Clone the Course Repository

**Your task**:
1. Open a new terminal
2. Navigate to a different directory (like `~/course_repos`)
3. Clone this repository: `https://github.com/MikeTheGreat/Command_Line_Practice.git`
4. Navigate into the cloned directory

**Questions**:
1. What files and directories were created?
2. Did you need to initialize a repository? Why not?
3. What happened in terms of the mental model? (Hint: remote → local repository → staging area → working tree, all at once!)

---

### Exercise 5.2: Explore the Cloned Repository

**Your task**:
1. Check the status
2. View the commit history as a graph
3. View the remote connections

**Questions**:
1. What is the remote called?
2. What URL does it point to?
3. Try to push to this repository - what happens? Why?

---

### Exercise 5.3: Make Local Commits (Without Pushing)

Even though you can't push to someone else's repository, you can make local commits!

**Your task**:
1. Create a file called `MY_NOTES.md` with any content
2. Stage it
3. Commit it with message "Add my personal notes"
4. View the commit history

**Questions**:
1. Is this commit on GitHub? (Check the repository page)
2. Can you still use Git locally even without pushing to a remote?
3. What's in your local repository that's not in the remote repository?

---

## Part 6: Visual Understanding - Drawing Diagrams

### Exercise 6.1: Draw the Git Workflow

**Your task**: On paper (or in a drawing tool), draw a diagram showing the complete Git workflow.

**Include these elements**:
1. Working Tree (your actual files)
2. Staging Area / Index (prepared changes)
3. Local Repository (.git folder)
4. Remote Repository (GitHub)

**Show these actions with labeled arrows**:
- `git add` (Working Tree → Staging Area)
- `git commit` (Staging Area → Local Repository)
- `git push` (Local Repository → Remote Repository)
- `git pull` (Remote Repository → Local Repository → Working Tree)
- `git clone` (Remote → everything at once)

**Reference**: Look back at the `learngitbranching.js.org` visualizations to help!

---

### Exercise 6.2: Draw Your Commit History

**Your task**: On paper, draw your commit history from `git_practice_local`:

**Show**:
1. Each commit as a circle or box (with abbreviated commit message)
2. Arrows pointing from each commit to its parent
3. Where `HEAD` is pointing
4. Where the `main` branch is pointing
5. Where `origin/main` (the remote branch) is pointing

**Hint**: Use `git log --oneline --graph --all` to help you see the structure

---

### Exercise 6.3: Draw Detached HEAD State

**Your task**: Draw TWO diagrams:

**Diagram 1**: Normal state
- Show HEAD pointing to main branch
- Show main branch pointing to latest commit
- Show commits pointing to their parents

**Diagram 2**: Detached HEAD state (when you checked out an earlier commit)
- Show HEAD pointing directly to an old commit
- Show main branch still pointing to latest commit
- Show that you're not on any branch

**Label** the difference between the two states clearly.

---

## Part 7: Reflection Questions

**Your task**: Answer these questions in a text file. You can create `REFLECTION.md` in your `git_practice_local` repo, commit it, and push it!

### Question 1: Mental Model
Explain in your own words what each of these represents:
- **Working Tree**:
- **Staging Area (Index)**:
- **Local Repository**:
- **Remote Repository**:

How do changes flow between them?

---

### Question 2: Common Commands
Describe what each command does AND which parts of the mental model it affects:
- `git status`:
- `git add`:
- `git commit`:
- `git log`:
- `git push`:
- `git pull`:

---

### Question 3: GitHub as Backup
How would you use GitHub as a personal backup solution? Describe the workflow for:
1. Setting up a new project with Git and GitHub
2. Regularly backing up your work (which commands, how often?)
3. Recovering your work on a different computer (which commands?)

---

### Question 4: Detached HEAD
1. What is a "detached HEAD" state?
2. How do you get into this state?
3. How do you get out of it?
4. When might you want to checkout an old commit?
5. In the mental model, what's different about where HEAD points in detached state vs normal state?

---

### Question 5: Commit Messages
1. Why are good commit messages important?
2. What makes a commit message good vs. bad?
3. Give an example of a good commit message and explain why it's good
4. Give an example of a bad commit message and explain why it's bad

---

## Summary: Commands You've Learned

### Repository Setup
- `git init` - Initialize a new Git repository
- `git clone <url>` - Clone an existing repository (remote → local repository → working tree)

### Basic Workflow (Moving through the mental model)
- `git status` - Check status of working tree and staging area
- `git add <file>` - Stage a file (working tree → staging area/index)
- `git add .` - Stage all changed files
- `git commit -m "message"` - Commit staged changes (staging area → local repository)
- `git log` - View commit history in local repository
- `git log --oneline` - View compact commit history
- `git log --oneline --graph --all` - View commit graph

### Examining Changes
- `git diff` - See unstaged changes (working tree vs staging area)
- `git diff --staged` - See staged changes (staging area vs local repository)
- `git show <commit>` - Show a specific commit from local repository

### Time Travel
- `git checkout <commit-hash>` - Go to a specific commit (detached HEAD)
- `git checkout main` - Return to the main branch (reattach HEAD)

### Remote Operations
- `git remote add origin <url>` - Connect to a remote repository
- `git push` - Send commits (local repository → remote repository)
- `git pull` - Get commits (remote repository → local repository → working tree)

---

## Next Steps

You've learned the fundamentals of solo Git usage! In future classes, you'll learn:
- Branching and merging
- Pull requests and code review
- Handling merge conflicts
- Team collaboration workflows

Great work!
