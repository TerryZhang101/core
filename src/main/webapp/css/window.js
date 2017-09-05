/////////////////////////////////////////////////////////////////
//
// Copyright (C) 2007 e-Channels CORPORATION
// 
// ALL RIGHTS RESERVED BY e-Channels CORPORATION, THIS PROGRAM
// MUST BE USED SOLELY FOR THE PURPOSE FOR WHICH IT WAS  
// FURNISHED BY e-Channels CORPORATION, NO PART OF THIS PROGRAM
// MAY BE REPRODUCED OR DISCLOSED TO OTHERS, IN ANY FORM
// WITHOUT THE PRIOR WRITTEN PERMISSION OF e-Channels CORPORATION.
// USE OF COPYRIGHT NOTICE DOES NOT EVIDENCE PUBLICATION
// OF THE PROGRAM
// 
//			e-Channels CONFIDENTIAL AND PROPRIETARY
// 
/////////////////////////////////////////////////////////////////
//
// 对window.js提供的窗口进行简单封装，提供给页面简单调用的方法
//	openNewWindow 用于在页面中显示一个唯一的窗口
//	openCallbackWindow 用于在页面中显示一个唯一的窗口，并且此窗口关闭时可回调指定函数
// 
// 可通过修改变量更改窗口的属性
// 窗口实现依赖以下类库：
// 	lib/prototype.js
//	lib/window.js
//	lib/effects.js
//
// @version 1.2
// @author zhanghao@yuchengtech.com
//
/////////////////////////////////////////////////////////////////
Window.keepMultiModalWindow=true;

var LIANA_SINGLETON_WINDOW = null;
var LIANA_SINGLETON_WINDOW_CLASS = 'spread';		//窗口显示样式
var LIANA_SINGLETON_WINDOW_POS_X = 20;				//窗口初始位置的X坐标值（零点位于左上）
var LIANA_SINGLETON_WINDOW_POS_Y = 40;				//窗口初始位置的Y坐标值（零点位于左上）
var LIANA_SINGLETON_WINDOW_WIDTH = 640;				//窗口初始宽度
var LIANA_SINGLETON_WINDOW_HEIGHT = 520;			//窗口初始高度
var LIANA_SINGLETON_WINDOW_ALLOW_MIN = false;		//窗口是否可以最小化
var LIANA_SINGLETON_WINDOW_ALLOW_MAX = false;		//窗口是否可以最大化
var LIANA_SINGLETON_WINDOW_ALLOW_RESIZE = false;	//窗口是否可以改变大小
var LIANA_SINGLETON_WINDOW_ALLOW_CLOSE = false;	//窗口是否可以关闭
var LIANA_SINGLETON_WINDOW_ALLOW_DRAG = false;		//窗口是否可以拖动
var LIANA_SINGLETON_WINDOW_EFFECT_DURATION = 0.6;	//窗口出现/消失效果持续时间（单位为秒）

/**
* 在新窗口中打开一个url
* @param {string} url
* @param {string} 窗口的标题栏
* @param {json}  传入一个json对象说明窗口的属性
*	json对象示例：{ top:20,left:20,width:200,height:100,min:true,max:true,resize:true,close:true,drag:true }
*	共有9个可设定的属性，若未设定，将使用默认设置。例如可只定义：{ drag:true }
*/
function openNewWindow(actionUrl,winTitle,windowProperties)
{
	closeWindow();
	createWindow( actionUrl,winTitle,windowProperties );
	LIANA_SINGLETON_WINDOW.show(); 
}

function openNewWinWithModal(actionUrl,winTitle,windowProperties){
	parent.openNewWindowForChildren(actionUrl,winTitle,windowProperties);
}

/**
* 在新窗口中打开一个url
* 窗口在关闭时，会回调指定的函数
* @param {string} 窗口的标题栏
* @param {json}  传入一个json对象说明窗口的属性
*	json对象示例：{ top:20,left:20,width:200,height:100,min:true,max:true,resize:true,close:true,drag:true }
*	共有9个可设定的属性，若未设定，将使用默认设置。例如可只定义：{ drag:true }
* @param {string} 窗口关闭时回调的函数名称
*/
function openCallbackWindow(actionUrl,winTitle,windowProperties,callbackFunction)
{
	closeWindow();
	createWindow( actionUrl,winTitle,windowProperties );
	LIANA_SINGLETON_WINDOW.setCloseCallback(callbackFunction);
	LIANA_SINGLETON_WINDOW.show(); 
}

/**
* 创建新窗口
*/
function createWindow( actionUrl,winTitle,windowProperties )
{
	var argumentsLength = arguments.length;
	if ( argumentsLength == 2 )
	{
		LIANA_SINGLETON_WINDOW = new Window({ 
			title: winTitle,
			url: actionUrl, 
			className: LIANA_SINGLETON_WINDOW_CLASS,
			left:LIANA_SINGLETON_WINDOW_POS_X, 
			top:LIANA_SINGLETON_WINDOW_POS_Y, 
			width:LIANA_SINGLETON_WINDOW_WIDTH, 
			height:LIANA_SINGLETON_WINDOW_HEIGHT,
			minimizable: LIANA_SINGLETON_WINDOW_ALLOW_MIN,
			maximizable: LIANA_SINGLETON_WINDOW_ALLOW_MAX,
			resizable: LIANA_SINGLETON_WINDOW_ALLOW_RESIZE,
			closable: LIANA_SINGLETON_WINDOW_ALLOW_CLOSE,
			draggable: LIANA_SINGLETON_WINDOW_ALLOW_DRAG,
			hideEffect: Element.hide,
			showEffectOptions: {duration:LIANA_SINGLETON_WINDOW_EFFECT_DURATION}});
	}else if ( argumentsLength == 3 )
	{
		// 根据传入的json对象获取窗口属性
		var topProperty = windowProperties.top;
		var leftProperty = windowProperties.left;
		var widthProperty = windowProperties.width;
		var heightProperty = windowProperties.height;
		var minProperty = windowProperties.min;
		var maxProperty = windowProperties.max;
		var resizeProperty = windowProperties.resize;
		var closeProperty = windowProperties.close;
		var dragProperty = windowProperties.drag;
		
		LIANA_SINGLETON_WINDOW = new Window({ 
			title: winTitle,
			url: actionUrl, 
			className: LIANA_SINGLETON_WINDOW_CLASS,
			left: ( leftProperty == undefined ) ? LIANA_SINGLETON_WINDOW_POS_X : leftProperty, 
			top: ( topProperty == undefined ) ? LIANA_SINGLETON_WINDOW_POS_Y : topProperty, 
			width: ( widthProperty == undefined ) ? LIANA_SINGLETON_WINDOW_WIDTH : widthProperty, 
			height: ( heightProperty == undefined ) ? LIANA_SINGLETON_WINDOW_HEIGHT : heightProperty, 
			minimizable:  ( minProperty == undefined ) ? LIANA_SINGLETON_WINDOW_ALLOW_MIN : minProperty, 
			maximizable:  ( maxProperty == undefined ) ? LIANA_SINGLETON_WINDOW_ALLOW_MAX : maxProperty, 
			resizable:  ( resizeProperty == undefined ) ? LIANA_SINGLETON_WINDOW_ALLOW_RESIZE : resizeProperty, 
			closable:  ( closeProperty == undefined ) ? LIANA_SINGLETON_WINDOW_ALLOW_CLOSE : closeProperty, 
			draggable:  ( dragProperty == undefined ) ? LIANA_SINGLETON_WINDOW_ALLOW_DRAG : dragProperty, 
			hideEffect: Element.hide,
			closeCallback: windowProperties.closeCallback,
			showEffectOptions: {duration:LIANA_SINGLETON_WINDOW_EFFECT_DURATION}});
	}
}

/**
* 关闭窗口
*/
function closeWindow() {
	if ( LIANA_SINGLETON_WINDOW != null ){
        // 解决IE在IFrame移除失去焦点导致无法输入BUG
        if(document.activeElement){
            document.activeElement.focus();
        }else{
            document.body.focus(); 
        }
        
		LIANA_SINGLETON_WINDOW.close();
		LIANA_SINGLETON_WINDOW.destroy();
		LIANA_SINGLETON_WINDOW = null;
		WindowUtilities.enableScreen.call('0000039601gwZ8011201303');
	}
}

//首页中用于子页面的弹出窗口方法
function openNewWindowForChildren(actionUrl,winTitle,windowProperties){
	var currentHeight = document.documentElement.offsetHeight;
	var currentScrollTop = document.body.scrollTop || document.documentElement.scrollTop;
	var currentWidth = document.body.clientWidth || document.documentElement.clientWidth;
	windowProperties.top = (currentHeight - windowProperties.height) / 2 + currentScrollTop;
	windowProperties.left = (currentWidth - windowProperties.width) / 2;
	var minTop = 155;
	if(windowProperties.top < minTop){
		windowProperties.top = minTop + 10;
	}
	closeWindow();
	WindowUtilities.disableScreen('mainPage_hide', '0000039601gwZ8011201303');
	var winProp = windowProperties || {};
	winProp.closeCallback = function(){
		WindowUtilities.enableScreen('0000039601gwZ8011201303');
		return true;
	};
	createWindow( actionUrl,'',windowProperties );
	LIANA_SINGLETON_WINDOW.show(); 
}