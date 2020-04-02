闭包

programming groovy 2 第5章


闭包像一个可以接受参数并且能够有返回值的方法，闭包仅仅是一个对象,groovy 提供了一种非常容易创建闭包的方式和启用了一些非常常用的行为。

闭包是由一些代码组成的对象,并且 groovy 为闭包提供了简洁的语法。

Groovy 使用闭包来指定这些每次都被执行的代码块,并且增加了许多额外的方法(each、
find、findAll、collect 等等)到集合类上,使他们容易使用,这些方法没有魔力,只是用来
简化了 groovy,因为闭包能够把控制逻辑从每次执行的代码块中分离出来,如果你发现你
想到的一个相似的结构没有在 groovy 中出现,可以容易的增加到 groovy 中。
把控制逻辑和每次迭代处理的逻辑分开不是介绍闭包概念的唯一原因,第二个原因(可
能是更重要的原因)是在处理资源的时候使用闭包。

// 闭包声明
闭包代码在一对花括号里,闭包的参数和代码通过箭头(->)进行分隔。
1、当只有一个参数传递给闭包的时候,这个参数的声明是可选的,魔术变量 it 代替了声明
def log = ''
(1..10).each { log += it } //魔幻变量it
assert log == '12345678910'

log = ''
(1..10).each { n -> log += n }
assert log == '12345678910'

2、变量赋值声明闭包
def printer = {line -> println line}

3、方法返回值声明闭包
def Closure getPrinter() {
    return {line -> println line }
}

4、引 用一 个方法 作为 闭包 是使用reference.&操作符,reference 是闭包调用时使用的对象实例