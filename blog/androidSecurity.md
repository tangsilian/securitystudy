#脱壳基础dvmDexFileOpenPartial
http://kiya.space/2015/12/16/unshell-basic/

##原理就是dalvik虚拟机会把dex文件通过dvmDexFileOpenPartial优化为odex文件,会加载dex。在这个点下钩子,把dex文件dump出来


#HOOk
利用函数a替换函数b，改变原来的代码逻辑。
一般都是利用框架如：xposed，cydia等


###也可以不用框架HOOK
如：http://bbs.pediy.com/showthread.php?t=192803



