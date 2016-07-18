//用户界面
Ext.onReady(function(){
	Ext.QuickTips.init();
	
	//将整个body分为3部分，top显示Logo，west显示菜单，main显示内容
	Ext.create('Ext.container.Viewport', {
		layout : 'border',
		frame : true,
		items : [{
			collapsible : false,
			contentEl : 'top',
			region : 'north',
			height : 185
		}, {
			title : '功能菜单',
			items : userMenu,
			split : true,
			collapsible : true,
			region : 'west',
			width : 200
		}, {
			title : '欢迎',
			contentEl : 'main',
			collapsible : false,
			bodyStyle : 'background:#DFE9F5;',
			id : 'mainContent',
			region : 'center'
		}]
	});
	
	var mainPanel = Ext.getCmp('mainContent');//获取主面板
	
	//显示用户信息的json读取器
	var userJsonReader = Ext.create('Ext.data.JsonReader', {
		 root : 'list',
	    totalProperty : 'totalCount',
	    id : 'id',
	    successProperty : '@success',
	    model : 'User'
	});
	
	/**
	 * 显示用户信息并提供修改信息支持的form
	 */
	var showUser = Ext.create("Ext.form.Panel", {
		title : '我的资料',
		frame : true,
		height : 300,
		width : 300,
		reader : userJsonReader,
		style : 'margin-left :40%;margin-top:3%;',
		buttonAlign : 'center',
		labelAlign : 'left',
		defualts : {
			labelSeparator : ' : '
		},
		defaultType : 'textfield',
		items : [{
			fieldLabel : '用户ID',
			name : 'user.id',
			id : 'id',
			readOnly : true,
			allowBlank : false,
			maxLength : 8,
			regex : /^[0-9]*$/,
			regexText : '只能是数字，学生用学号，教职工用工号',
			msgTarget : 'side'
		}, {
			fieldLabel : '用户名',
			name : 'user.username',
			allowBlank : false,
			id : 'username',
			maxLength : 20,
			regex : /^[A-Za-z0-9]+$/,
			regexText : '只能是数字、字母',
			msgTarget : 'side'
		}, {
			name : 'user.password',
			hidden : true,
			id : 'password'
		}, {
			fieldLabel : '真实姓名',
			name : 'user.relname',
			id : 'relname',
			allowBlank : false,
			maxLength : 20,
			msgTarget : 'side'
		}, {
			name : 'user.post.id',
			hidden : true,
			id : 'post.id'
		}, {
			fieldLabel : '职务',
			name : 'user.post.postname',
			id : 'post.postname',
			readOnly : true,
			allowBlank : false,
			msgTarget : 'side'
		}, {
			fieldLabel : 'E-mail',
			name : 'user.email',
			id : 'email',
			allowBlank : false,
			regex : /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/,
			regexText : '邮箱格式为XXX@XXX.com',
			msgTarget : 'side'
		}, {
			fieldLabel : '电话',
			name : 'user.tel',
			id : 'tel',
			allowBlank : false,
			regex : /^[1][3-8]+\d{9}/,
			regexText : '请输入正确的电话',
			msgTarget : 'side'
		}, {
			fieldLabel : '班级',
			name : 'user.clazz',
			id : 'clazz',
			allowBlank : true,
			maxLength : 20,
			msgTarget : 'side'
		}, {
			fieldLabel : 'QQ',
			name : 'user.qq',
			id : 'qq',
			maxLength : 10,
			allowBland : true,
			msgTarget : 'side'
		}],
		buttons : [{
			text : '保存',
			iconCls : 'save',
			disabled : false,
			handler : function(b){
				saveModifyUser(b.ownerCt.ownerCt);
			}
		}]
	});
	
	/**
	 * 显示用户以往消息的界面
	 */
	var showOldMessage = Ext.create("Ext.grid.Panel", {
		title : '我的消息',//标题
		width : 900,
		height : 400,
		style : 'margin:10px 12% 0;',
		columns : [
			{xtype : 'rownumberer'},
			{text:'内容', dataIndex:'content', width : 600},
			{text:'时间', dataIndex:'time', width : 120},
			{header : "操作", xtype : 'actioncolumn', width : 100,
				items : [{
					icon : 'image/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteMessage(grid, row, col);
					}
			}]}
		],
		store : Ext.data.StoreManager.lookup('userMessageStore'),
		selType : 'checkboxmodel',
		multiSelect : true,
		tbar : [
			{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){deleteMessages(btn.ownerCt.ownerCt);}}
		],
		dockedItems : [{
			xtype : 'pagingtoolbar',
			store : Ext.data.StoreManager.lookup('userMessageStore'),
			dock : 'bottom',
			displayInfo : true
		}],
		frame : true,
		loadMask : true
	});
	
	//为修改密码提供的自定义数据验证
	Ext.apply(Ext.form.field.VTypes, {
		pass : function(value, field){
			if(field.confirmTo){
				var pwd=Ext.getCmp(field.confirmTo);
				if(value == pwd.getValue()){
					return true;
				} else {
					return false;
				}
			}
		},
		passText : '两次密码输入不同'
	});
	/**
	 * 修改密码窗体
	 */
	var modifyPass = Ext.create('Ext.form.Panel', {
		title : '修改密码',
		frame : true,
		height : 200,
		width : 300,
		style : 'margin-left :40%;margin-top:10%;',
		labelAlign : 'left',
		defualts : {
			labelSeparator : ' : '
		},
		defaultType : 'textfield',
		items : [{
			fieldLabel : '原始密码',
			name : 'userDTO.prepass',
			allowBlank : false,
			maxLength : 20,
			inputType : 'password',
			regex : /^[\w]{6,}$/,
			regexText : '密码只能包含数字、字母、下划线，长度不少于6位',
			msgTarget : 'side'
		}, {
			fieldLabel : '新&nbsp;密&nbsp码',
			name : 'userDTO.newpass',
			id : 'newpass',
			allowBlank : false,
			maxLength : 20,
			inputType : 'password',
			regex : /^[\w]{6,}$/,
			regexText : '密码只能包含数字、字母、下划线，长度不少于6位',
			msgTarget : 'side'
		}, {
			fieldLabel : '确认密码',
			name : 'userDTO.compass',
			allowBlank : false,
			maxLength : 20,
			inputType : 'password',
			regex : /^[\w]{6,}$/,
			regexText : '密码只能包含数字、字母、下划线，长度不少于6位',
			msgTarget : 'side',
			vtype : 'pass',
			confirmTo : 'newpass'
		}],
		buttons : [{
			text : '确定',
			iconCls : 'save',
			disabled : false,
			handler : function(b){
				modifyPassword(b.ownerCt.ownerCt);
			}
		}]
	});
	
	/**
	 * 器件申领界面
	 */
	var showElements = Ext.create('Ext.grid.Panel', {
		title : '器件申领',
		width : 1000,
		height : 400,
		style : 'margin:10px 8% 0;',
		columns : [
			{xtype : 'rownumberer'},
			{text:'编号', dataIndex:'id', width : 150},
			{text:'名称', dataIndex:'elementname', width :120},
			{text:'类型', dataIndex:'type.typename', width : 120},
			{text:'封装', dataIndex:'feature', width : 120},
			{text:'库存量', dataIndex:'store', width : 100,
				renderer : function(value){
					if(value == 0){
						return '<font color=red>' + value + '</font>';
					} else{
						return '<font color=black>' + value + '</font>';
					}
				}
			},
			{text:'所在地', dataIndex:'locker.addr', width : 100},
			{text:'存储柜', dataIndex:'locker.id', width : 100},
			{header : "操作", xtype : 'actioncolumn', width : 100,
				items : [{
					icon : 'image/look.ico',
					tooltip : '查看详情',
					handler : function(grid, row, col){
						showElementDetail(grid, elementForm, row);
						elementWindow.show();
					}
				}, {
					icon : 'image/displayall.ico',
					tooltip : '手册下载',
					handler : function(grid, row, col){
						download(grid, row, col);
					}
				}, {
					icon : 'image/confirm.ico',
					tooltip : '申领',
					handler : function(grid, row, col){
						setBorrowWindow(grid, borrowWindow.down('form'), row);
						borrowWindow.show();
					}
				}]
			}
		],
		store : Ext.data.StoreManager.lookup('ElementStore'),
		dockedItems : [{
			xtype : 'pagingtoolbar',
			store : Ext.data.StoreManager.lookup('ElementStore'),
			dock : 'bottom',
			displayInfo : true
		}],
		frame : true,
		loadMask : true
	});
	/**
	 * 显示设备和耗材的详细信息
	 */
	var elementForm = Ext.create('Ext.form.Panel', {
		height : 500,
		width : 400,
		labelAlign : 'left',
		style : 'padding-top:10; padding-left:65',
		defualts : {
			labelSeparator : ' : '
		},
		defaultType : 'textfield',
		items :[{
			fieldLabel : '编号',
			name : 'id',
			readOnly : true
		}, {
			fieldLabel : '名称', 
			name : 'elementname',
			readOnly : true
		}, {
			fieldLabel : '类型', 
			name : 'typename',
			readOnly : true
		}, {
			fieldLabel : '封装类型', 
			name : 'feature',
			readOnly : true
		}, {
			fieldLabel : '库存', 
			name : 'store',
			readOnly : true
		}, {
			fieldLabel : '存储地', 
			name : 'lockAddr',
			readOnly : true
		}, {
			fieldLabel : '存储柜', 
			name : 'locker',
			readOnly : true
		}, {
			xtype : 'image',
			fieldLabel : '图片',
			width : 200,
			height : 200,
			src : 'image/notfound.png'
		}],
		buttons : [{
			text : '确定',
			iconCls : 'cancel',
			disabled : false,
			handler : function(b){
				elementWindow.hide();
			}
		}],
		frame : true,
		loadMask : true
	});
	var elementWindow = Ext.create('Ext.window.Window', {
		title : '设备与耗材详情',
		width : 400,
		height : 500,
		layout : 'fit',
		plain : true,
		closeAction : 'hide',
		resizable : 'false',
		items : elementForm
	});
	/**
	 * 申领窗口。
	 */
	var borrowWindow = Ext.create('Ext.window.Window', {
		title : '填写申请',
		width : 400,
		height : 500,
		layout : 'fit',
		plain : true,
		closeAction : 'hide',
		resizable : 'false',
		items : {
			xtype : 'form',
			style : 'padding-top:80; padding-left:65',
			height : 470,
			width : 390,
			labelAlign : 'left',
			defaultType : 'textfield',
			defualts : {
				labelSeparator : ' : '
			},
			items : [{
				fieldLabel : '器件编号',
				name : 'element.id',
				readOnly : true
			}, {
				fieldLabel : '器件名称',
				name : 'elementname',
				readOnly : true
			}, {
				xtype : 'numberfield',
				fieldLabel : '申请件数',
				name : 'tempBorrow.count',
				value : 1,
				minValue : 1,
				maxValue : 100,
				nanText : '请输入有效数字',
				allowDecimals : false,
				msgTarget : 'side'
			}, {
				xtype : 'textarea',
				fieldLabel : '申请目的',
				height : 150,
				name : 'tempBorrow.purpose'
			}],
			buttons : [{
				text : '确定',
				iconCls : 'save',
				disabled : false,
				handler : function(b){
					borrowWindow.hide();
					saveBorrow(b.ownerCt.ownerCt);
				}
			}, {
				text : '取消',
				iconCls : 'cancel',
				disabled : false,
				handler : function(b){
					borrowWindow.hide();
				}
			}],
			frame : true,
			loadMask : true
		}
	});
	/**
	 * 申领记录
	 * 为tabPanel加tabchange事件，判定当前要显示的页面是哪一个，然后加载相应的store即可
	 */
	var borrowRecord = Ext.create("Ext.tab.Panel",{
		title : '申领记录',
		width : 1000,
		height : 400,
		style : 'margin:10px 8% 0;',
		activeTap : 0,
		layout : 'fit',
		items : [{
			title : '待审核',
			xtype : 'gridpanel',
			columns : [
			{xtype : 'rownumberer'},
			{text:'设备编号', dataIndex:'element.id', width:100},
			{text:'设备名称', dataIndex:'element.elementname', width:120},
			{text:'封装类型', dataIndex:'element.feature', width:80},
			{text:'类型', dataIndex:'element.type.typename', width:80},
			{text:'仓库', dataIndex:'element.locker.addr', width:80},
			{text:'储物柜', dataIndex:'element.locker.id', width:80},
			{text:'库存量', dataIndex:'element.store', width:95,
				renderer : function(value){
					if(value == 0){
						return '<font color=red>' + value + '</font>';
					} else{
						return '<font color=black>' + value + '</font>';
					}
				}},
			{text:'申请数量', dataIndex:'count', width:100},
			{text:'申请日期', dataIndex:'time', width:100},
			{header : '操作', xtype : 'actioncolumn', width:100,
				items : [{
					icon : 'image/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteTempBorrow(grid, row, col);
					}
				}]
			}],
			store : Ext.data.StoreManager.lookup('userTempBorrowStore'),
			selType : 'checkboxmodel',
			multiSelect : true,
			tbar : [
				{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){deleteTempBorrows(btn.ownerCt.ownerCt);}}
			],
			dockedItems : [{
				xtype : 'pagingtoolbar',
				store : Ext.data.StoreManager.lookup('userTempBorrowStore'),
				dock : 'bottom',
				displayInfo : true
			}],
			frame : true,
			loadMask : true
		}, {
			title : '已通过',
			xtype : 'gridpanel',
			columns : [
			{xtype : 'rownumberer'},
			{text:'设备编号', dataIndex:'element.id', width:80},
			{text:'设备名称', dataIndex:'element.elementname', width:80},
			{text:'封装类型', dataIndex:'element.feature', width:80},
			{text:'类型', dataIndex:'element.type.typename', width:60},
			{text:'仓库', dataIndex:'element.locker.addr', width:60},
			{text:'储物柜', dataIndex:'element.locker.id', width:60},
			{text:'库存量', dataIndex:'element.store', width:60,
				renderer : function(value){
					if(value == 0){
						return '<font color=red>' + value + '</font>';
					} else{
						return '<font color=black>' + value + '</font>';
					}
				}},
			{text:'申请数量', dataIndex:'count', width:80},
			{text:'申请日期', dataIndex:'time', width:80},
			{text:'审核人', dataIndex:'verifier.relname', width:80},
			{text:'状态', dataIndex:'returned', width:80, 
				renderer : function(value){
					if(value == -1){
						return '<font color="#BEBCBC">无需归还</font>';
					} else if(value == 0){
						return '<font color=red>未归还</font>';
					} else{
						return '<font color=black>已归还</font>';
					}
				}
			}, {header : '操作', xtype : 'actioncolumn', width:100,
				items : [{
					icon : 'image/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deletePassBorrow(grid, row, col);
					}
				}]
			}],
			store : Ext.data.StoreManager.lookup('userPassBorrowStore'),
			selType : 'checkboxmodel',
			multiSelect : true,
			tbar : [
				{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){deletePassBorrows(btn.ownerCt.ownerCt);}}
			],
			dockedItems : [{
				xtype : 'pagingtoolbar',
				store : Ext.data.StoreManager.lookup('userPassBorrowStore'),
				dock : 'bottom',
				displayInfo : true
			}],
			frame : true,
			loadMask : true
		}, {
			title : '已拒绝',
			xtype : 'gridpanel',
			columns : [
			{xtype : 'rownumberer'},
			{text:'设备编号', dataIndex:'element.id', width:100},
			{text:'设备名称', dataIndex:'element.elementname', width:115},
			{text:'封装类型', dataIndex:'element.feature', width:80},
			{text:'类型', dataIndex:'element.type.typename', width:80},
			{text:'仓库', dataIndex:'element.locker.addr', width:80},
			{text:'储物柜', dataIndex:'element.locker.id', width:80},
			{text:'库存量', dataIndex:'element.store', width:80,
				renderer : function(value){
					if(value == 0){
						return '<font color=red>' + value + '</font>';
					} else{
						return '<font color=black>' + value + '</font>';
					}
				}},
			{text:'申请数量', dataIndex:'count', width:80},
			{text:'申请日期', dataIndex:'time', width:80},
			{text:'审核人', dataIndex:'verifier.relname', width:80},
			{header : '操作', xtype : 'actioncolumn', width:80,
				items : [{
					icon : 'image/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteRefuseBorrow(grid, row, col);
					}
				}]
			}],
			store : Ext.data.StoreManager.lookup('userRefuseBorrowStore'),
			selType : 'checkboxmodel',
			multiSelect : true,
			tbar : [
				{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){deleteRefuseBorrow(btn.ownerCt.ownerCt);}}
			],
			dockedItems : [{
				xtype : 'pagingtoolbar',
				store : Ext.data.StoreManager.lookup('userRefuseBorrowStore'),
				dock : 'bottom',
				displayInfo : true
			}],
			frame : true,
			loadMask : true
		}]
	});
	//为tabpanel添加切换面板事件
	borrowRecord.on('tabchange', function(tabPanel, newCard, oldCard){
		if(newCard.title == '待审核')
			Ext.data.StoreManager.lookup('userTempBorrowStore').load({
				params: {
					start : 0,
					page : 1,
					limit : 15
				}
			});
		else if(newCard.title == '已通过')
			Ext.data.StoreManager.lookup('userPassBorrowStore').load({
				params: {
					start : 0,
					page : 1,
					limit : 15
				}
			});
		else
			Ext.data.StoreManager.lookup('userRefuseBorrowStore').load({
				params: {
					start : 0,
					page : 1,
					limit : 15
				}
			});
	});
	/**
	 * 器件申购
	 */
	var por = Ext.create('Ext.form.Panel', {
		title : '器件申购',
		frame : true,
		height : 420,
		width : 300,
		fileUpload : true,
		style : 'margin-left :35%;margin-top:5; padding-left:20;',
		buttonAlign : 'center',
		labelAlign : 'left',
		defualts : {
			labelSeparator : ' : '
		},
		defaultType : 'textfield',
		items : [{
			fieldLabel : '器件名称',
			name : 'tempElement.elementname',
			allowBlank : false,
			msgTarget : 'side'
		}, {
			xtype : 'combobox',
			fieldLabel : '器件类型',
			maxHeight : 20,
			name : 'tempElement.type.id',
			value : 0,
			allowBlank : false,
			queryMode : 'remote',
			store : Ext.data.StoreManager.lookup('TypeStore'),
			valueField : 'id',
			displayField : 'typename',
			forceSelection : true,
			typeAhead : true,
			msgTarget : 'side'
		}, {
			fieldLabel : '封装类型',
			name : 'tempElement.feature',
			allowBlank : false,
			msgTarget : 'side'
		}, {
			xtype : 'numberfield',
			value : 1,
			minValue : 1,
			fieldLabel : '购买数量',
			name : 'tempElement.count',
			allowBlank : false,
			msgTarget : 'side'
		}, {
			xtype : 'numberfield',
			value : 1,
			minValue : 1,
			fieldLabel : '器件单价',
			name : 'tempElement.price',
			allowBlank : false,
			msgTarget : 'side'
		}, {
			fieldLabel : '上传照片',
			inputType : 'file',
			name : 'img',
			id : 'img',
			regex : /\.(jpg|gif|bmp|png)/,
			regexText : '图片格式只能为.jpg/.gif/.bmp/.png',
			msgTarget : 'side',
			listeners : {
				'render' : function(){
					this.on('change', function(field, newValue, oldValue){
						var url = "file:///" + this.getValue();
						this.up().down('image').setSrc(url);
					}, this);
				}
			}
		}, {
			fieldLabel : '上传手册',
			inputType : 'file',
			name : 'manual',
			regex : /\.(doc|docx|pdf|txt)/,
			regexText : '文件格式只能为.doc/.docx/.pdf/.txt',
			msgTarget : 'side'
		}, {
			xtype : 'textarea',
			fieldLabel : '其它信息',
			name : 'tempPor.info'
		}, {
			xtype : 'image',
			style : 'margin-left : 105',
			width : 85,
			height : 85,
			src : ''
		}],
		buttons : [{
			text : '保存',
			iconCls : 'save',
			disabled : false,
			handler : function(b){
				savePor(b.ownerCt.ownerCt);
			}
		}, {
			text : '重置',
			iconCls : 'cancel',
			disabled : false,
			handler : function(b){
				b.ownerCt.ownerCt.form.reset();
			}
		}]
	});
	
	/**
	 * 显示申购记录
	 */
	var porRecord = Ext.create('Ext.tab.Panel', {
		title : '申购记录',
		width : 1000,
		height : 400,
		style : 'margin:10px 8% 0;',
		activeTap : 0,
		items : [{
			title : '待审核',
			xtype : 'gridpanel',
			columns : [
			{xtype : 'rownumberer'},
			{text:'器件名称', dataIndex:'tempElement.elementname'},
			{text:'设备类型', dataIndex:'tempElement.type.typename'},
			{text:'封装类型', dataIndex:'tempElement.feature'},
			{text:'申购数量', dataIndex:'tempElement.count'},
			{text:'器件单价', dataIndex:'tempElement.price'},
			{text:'申购日期', dataIndex:'time'},
			{header : "操作", xtype : 'actioncolumn',
				items : [{
					icon : 'image/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteTempPor(grid, row, col);
					}
				}]
			}],
			store : Ext.data.StoreManager.lookup('userTempPorStore'),
			selType : 'checkboxmodel',
			multiSelect : true,
			tbar : [
				{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){deleteTempPors(btn.ownerCt.ownerCt);}}
			],
			dockedItems : [{
				xtype : 'pagingtoolbar',
				store : Ext.data.StoreManager.lookup('userTempPorStore'),
				dock : 'bottom',
				displayInfo : true
			}],
			frame : true,
			loadMask : true
		}, {
			title : '已通过',
			xtype : 'gridpanel',
			columns : [
				{xtype : 'rownumberer'},
				{text:'器件名称', dataIndex:'tempElement.elementname'},
				{text:'设备类型', dataIndex:'tempElement.type.typename'},
				{text:'封装类型', dataIndex:'tempElement.feature'},
				{text:'申购数量', dataIndex:'tempElement.count'},
				{text:'器件单价', dataIndex:'tempElement.price'},
				{text:'申购日期', dataIndex:'time'},
				{text:'审核人', dataIndex:'verifier.relname'}
			],
			store : Ext.data.StoreManager.lookup('userPassPorStore'),
			dockedItems : [{
				xtype : 'pagingtoolbar',
				store : Ext.data.StoreManager.lookup('userPassPorStore'),
				dock : 'bottom',
				displayInfo : true
			}],
			frame : true,
			loadMask : true
		}, {
			title : '已拒绝',
			xtype : 'gridpanel',
			columns : [
			{xtype : 'rownumberer'},
			{text:'器件名称', dataIndex:'tempElement.elementname'},
			{text:'设备类型', dataIndex:'tempElement.type.typename'},
			{text:'封装类型', dataIndex:'tempElement.feature'},
			{text:'申购数量', dataIndex:'tempElement.count'},
			{text:'器件单价', dataIndex:'tempElement.price'},
			{text:'申购日期', dataIndex:'time'},
			{text:'审核人', dataIndex:'verifier.relname', width:100},
			{header : "操作", xtype : 'actioncolumn',
				items : [{
					icon : 'image/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteRefusePor(grid, row, col);
					}
				}]
			}],
			store : Ext.data.StoreManager.lookup('userRefusePorStore'),
			selType : 'checkboxmodel',
			multiSelect : true,
			tbar : [
				{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){deleteRefusePors(btn.ownerCt.ownerCt);}}
			],
			dockedItems : [{
				xtype : 'pagingtoolbar',
				store : Ext.data.StoreManager.lookup('userRefusePorStore'),
				dock : 'bottom',
				displayInfo : true
			}],
			frame : true,
			loadMask : true
		}]
	});
	porRecord.on('tabchange', function(tabPanel, newCard, oldCard){
		if(newCard.title == '待审核')
			Ext.data.StoreManager.lookup('userTempPorStore').load({
				params: {
					start : 0,
					page : 1,
					limit : 15
				}
			});
		else if(newCard.title == '已通过')
			Ext.data.StoreManager.lookup('userPassPorStore').load({
				params: {
					start : 0,
					page : 1,
					limit : 15
				}
			});
		else
			Ext.data.StoreManager.lookup('userRefusePorStore').load({
				params: {
					start : 0,
					page : 1,
					limit : 15
				}
			});
	});
	/**
	 * 设备归还界面
	 */
	var ReturnPanel = Ext.create('Ext.grid.Panel', {
		title : '设备归还',
		width : 1000,
		height : 400,
		style : 'margin:10px 8% 0;',
		columns : [
			{xtype : 'rownumberer'},
			{text:'设备编号', dataIndex:'element.id', width:100},
			{text:'设备名称', dataIndex:'element.elementname', width:115},
			{text:'封装类型', dataIndex:'element.feature', width:80},
			{text:'类型', dataIndex:'element.type.typename', width:80},
			{text:'仓库', dataIndex:'element.locker.addr', width:80},
			{text:'储物柜', dataIndex:'element.locker.id', width:80},
			{text:'库存量', dataIndex:'element.store', width:80,
				renderer : function(value){
					if(value == 0){
						return '<font color=red>' + value + '</font>';
					} else{
						return '<font color=black>' + value + '</font>';
					}
				}},
			{text:'申请数量', dataIndex:'count', width:80},
			{text:'申请日期', dataIndex:'time', width:80},
			{text:'审核人', dataIndex:'verifier.relname', width:80},
			{header : '操作', xtype : 'actioncolumn', width:80,
				items : [{
					icon : 'image/displayall.ico',
					tooltip : '归还',
					handler : function(grid, row, col){
						returnElement(grid, row, col);
					}
				}]
			}
		],
		tbar : [
			{xtype : 'button', text : '归还', iconCls:'displayAll', style:'margin-left:40px;', handler: function(btn){returnElements(btn.ownerCt.ownerCt);}}
		],
		store : Ext.data.StoreManager.lookup('returnPassBorrowStore'),
		selType : 'checkboxmodel',
		multiSelect : true,
		dockedItems : [{
			xtype : 'pagingtoolbar',
			store : Ext.data.StoreManager.lookup('returnPassBorrowStore'),
			dock : 'bottom',
			displayInfo : true
		}],
		frame : true,
		loadMask : true
	});
	/**
	 * 新消息显示窗口
	 */
	var NewMessageWindow = Ext.create('Ext.window.Window', {
		title : '新消息',
		width : 900,
		height : 500,
		layout : 'fit',
		plain : true,
		closeAction : 'hide',
		resizable : 'false',
		items : {
			xtype : 'gridpanel',
			columns : [
				{xtype : 'rownumberer'},
				{text:'内容', dataIndex:'content', width : 600},
				{text:'时间', dataIndex:'time', width : 120},
				{header : "操作", xtype : 'actioncolumn', width : 100,
					items : [{
						icon : 'image/confirm.ico',
						tooltip : '标记为已读',
						handler : function(grid, row, col){
							checkMessage(grid, row, col);
						}
				}]}
			],
			store : Ext.data.StoreManager.lookup('newMessageStore'),
			selType : 'checkboxmodel',
			multiSelect : true,
			tbar : [
				{xtype : 'button', text : '标记为已读', iconCls:'confirm', style:'margin-left:40px;', handler: function(btn){checkMessages(btn.ownerCt.ownerCt);}}
			],
			dockedItems : [{
				xtype : 'pagingtoolbar',
				store : Ext.data.StoreManager.lookup('newMessageStore'),
				dock : 'bottom',
				displayInfo : true
			}],
			frame : true,
			loadMask : true
		}
	});
	var aNewMessage = Ext.get('newMessage');
	aNewMessage.on('click', function(){
		NewMessageWindow.show();
		Ext.data.StoreManager.lookup('newMessageStore').load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}});
	});
	
	//为树形菜单增加单击时间，根据id判断要添加的面板
	userMenu.on({
		'itemclick' : function(view, record, item, index, event, options){
			if(record.get('leaf')){
				showModifyUser(record, mainPanel, showUser);
				showMyMessage(record, mainPanel, showOldMessage, Ext.data.StoreManager.lookup('userMessageStore'));
				showModifyPass(record, mainPanel, modifyPass);
				showElementList(record, mainPanel, showElements, Ext.data.StoreManager.lookup('ElementStore'));
				showBorrowRecord(record, mainPanel, borrowRecord, Ext.data.StoreManager.lookup('userTempBorrowStore'));
				showPor(record, mainPanel, por);
				showPorRecord(record, mainPanel, porRecord, Ext.data.StoreManager.lookup('userTempPorStore'));
				showReturnPanel(record, mainPanel, ReturnPanel, Ext.data.StoreManager.lookup('returnPassBorrowStore'));
				//消除HTML div上的内容
				var mainDiv = Ext.getDom('main');
				mainDiv.innerHTML = '';
			}
		}
	});
});