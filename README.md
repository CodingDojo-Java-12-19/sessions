# Java

Most instructions assume a Unix based system or using Gitbash on Windows

## Lectures

[Link](https://vimeo.com/showcase/6606831)

## Git Instructions

* Ensure `git` is installed - type `git` in your terminal and you should see command options  
  - Otherwise install from your package manager (`brew` or `apt`, etc) or (Windows) download the [installer](https://git-scm.com/)  
* In your terminal, in your current stack content directory: `git clone github-url` ex. `git clone https://github.com/DojoDrills/java-assignment-landscape`
* cd into the created directory
* delete the `.git` directory (may be hidden) `rm -rf .git`
* reinitialize git: `git init`
* configure git for the local project (may not be necessary): `git config user.name 'your-user-name'` and `git config user.email your@email.com`
* add files: `git add .`
* commit files: `git commit -m 'some message that relates to current changes'`

## Github Instructions

* Create a repo in your organization
* Name your repo, do not add a `.gitignore`, `README` or `LICENSE`
* Hit `Create Repository`
* Copy the url from your browser
* In your terminal: `git remote add origin your-github-url`
* Then push changes: `git push origin master`

## Basic Workflow

After the initialization steps above your basic workflow may look like this...  

* Make code changes/complete assignments
* Add files to track: `git add .`
* Commit changes: `git commit -m 'some relevant message'`
* Push changes to remote: `git push origin master`

### Additional Commands

* To see changes or the current status: `git status`
* To view the remote url: `git remote show origin`
