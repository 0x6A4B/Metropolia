I tried to google and asked llama, but it seems there's a global .gitignore that can be set and there are subfolder .gitignores.

I have Metropolia -repo with 2024_Kevät/ /2025_Syys/ etc. subfolders.
Within those I have 2024_Kevät/OOP/ for java and now 2024_Kevät/Web/ for js/ts/nextjs/react/expressjs

Many of these are generated with npm for example and come with gitignores that is a good thing, but when I'm doing git status in nextjs directory it shows to me that I'm not tracking out/ directories which are intellij build directories for java and I don't want to track them. They are ignored in a Metropolia -repo root .gitignore but seems to be ignored in nextjs direcotry where the local .gitignore seems to override.

I don't want to add everything manually to the root gitignore and I also would probably not want to have a global gitignore that affects other repos outside of Metropolia repo

So I was hoping I could have a GLOBAL gitignore for all repos in all gitservers

But also a repo specific root gitignore. This is probably pretty fringe case situation.
Perhaps better usage would be to have Metropolia project with courses as repos inside it and a readme tying it to certain semesters.

Dir structure
- ~/Metropolia
  - 2024_Kevät
    - OOP/ -java ignores needed
    - Web - js / node ignores needed
      - nextjs - ts and nextjs ignores needed
      - reactjs - js and reactjs ignores needed

- ~/OtherGitRepos - need their specific ignores per language


I could use a global, if it really is not overriden, and gather ALL the ignores to there, but that seems wrong and unwieldy.
Of course if one repo is per language we can use language specific gitignore there but if you have a repo for all studies or all mini projects/tests/sandbox playing you need gitignore for a lot of frameworks and languages and buildautomations and ides (maven, gradle, intellij idea, vscode)



I got these answers

```
Subfolder ignore patterns override global ignore patterns for files and directories within that directory and its subdirectories.


To set up a global .gitignore file:

- Create a new file named .gitignore in your home directory.
- On Unix-based systems: git config --global core.excludesFile ~/.gitignore

```
