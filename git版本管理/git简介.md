# Git

## Git命令

### git init

> 通过`git init`命令把这个目录变成Git可以管理的仓库

在当前目录下，多了一个.git的目录，这个目录是Git来跟踪管理版本库的。（不能随意修改）

### git add

> 通过`git add`命令，把文件添加到仓库

### git commit

> 通过`git commit`命令，把文件提交到仓库

tip: 

`git commit`命令后接的参数`-m`，表示后接本次提交的说明，一般表明本次项目本次的改动

### git status

> 通过`git status`命令查询仓库当前的状态

### git diff

> 查看差异，显示的格式是Unix通用的diff格式（命令后接文件路径）

### git log

> 该命令显示从最近到最远的提交日志，如果觉得输出信息太多，可以加上`--pretty=oneline`参数

### git reset

tip:
在Git中，HEAD表示当前版本，也就是最新的提交，上一个版本就是`HEAD^`，上上一个版本是`HEAD^^`，一般版本多了以后可以使用`HEAD~100`这个方式的

> 该命令用于回退版本，reset命令后可接参数`--head`

### git reflog

> 该命令用来记录每一次命令