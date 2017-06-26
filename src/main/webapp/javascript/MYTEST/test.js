/*//常见的JS基础问题
//1.'=='和'==='的区别 
var num = 1;
var str = '1';
var num1 = 1;
console.log(num == num1);//true 只要是值相同即可
console.log(num === num1);//true 表示值和类型都相同
console.log(num !== num1);//false
console.log(num == str);//true
console.log(num === str);//false

var person = function() {
	this.test2 = function () {
		console.log('jjtest');
	}
	console.log('....');
}

person.prototype.name = 'guanzf';
person.prototype.test = function() {
	console.log('pro test');
}
person.test = function() {
	console.log('test');
}

var p = new person();
var p1 = new person();
console.log(p.name);
console.log(p1.name);
p.name = 'test';
console.log(p1.name);
console.log(p.name);
console.log('---------------');
person.test();
p.test2();
p.test();*/

/*(function(test) {
	console.log(test);
})('guanzf');*/

/*var person = function() {
	
}

person.prototype.name = 'guanzf';
person.prototype.password = '123456';
person.prototype.say = function(word) {
	if (word) {
		console.log('你说的是:' + word);
	} else {
		console.log('你没说任何')
	}
}
window.p = new person();
console.log(p);
console.log($);
p.say('我是好人');*/

/*function Foo() {
    getName = function () { console.log(1); };
    return this;
}
Foo.getName = function () { console.log (2);};
Foo.prototype.getName = function () { console.log (3);};
var getName = function () { console.log (4);};
function getName() { console.log (5);}

//答案：
Foo.getName();//2
getName();//4
Foo().getName();//1
getName();//1
new Foo.getName();//2
new Foo().getName();//3
new new Foo().getName();//3
*/

/*function guanzf() {
	name = 'guanzf';
	this.name1 = 'guanzf';
}

guanzf.prototype.name2 = 'guanzf';
var guanzf = new guanzf();*/

/*(function() {
    var a = b = 5;
})();
console.log(b);
console.log('---------------');*/

//变量提升和函数表示
/*function test() {
	console.log(a);
	console.log(foo());
	var a = 1;
	function foo() {
		return 2;
	}
}
test();*/

/*console.log(typeof NaN);
console.log(typeof null);
console.log(typeof undefined);
var test = [1, 2, 3];
for ( var i in test) {
	console.log(test[i]);
}

(function() {
	console.log('jjj');
})();*/

var s = 'guanzf';
console.log(new RegExp('[a-z]{1,8}').test(s));


var single = (function() {
	var unique;
	function getInstance() {
		if (unique === undefined) {
			unique = new Construct();
		}
		return unique;
	}
	function Construct() {
		// ... 生成单例的构造函数的代码
	}
	return {
		getInstance : getInstance
	}
})();

console.log(single);



