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
			items : superAdminMenu,
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
	/**
	 * 显示用户信息并提供修改信息支持的form
	 */
	//显示用户信息的json读取器
	var userJsonReader = Ext.create('Ext.data.JsonReader', {
		 root : 'list',
	    totalProperty : 'totalCount',
	    id : 'id',
	    successProperty : '@success',
	    model : 'User'
	});
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
		title : '我的资料',
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
	/**
	 * 发布公告窗体
	 */
	var addNoticeWindow = Ext.create('Ext.window.Window',{
		title : '发布公告',
		width : 585,
		height : 350,
		layout : 'fit',
		plain : true,
		closeAction : 'hide',
		resizable : false,
		items : [{
			xtype : 'form',
			frame : true,
			labelAlign : 'left',
			defualts : {
				labelSeparator : ' : '
			},
			defaultType : 'htmleditor',
			items : [{
				allowBlank : false,
				blankText : '请输入内容',
				name : 'notice.content',
				height : 300
			}],
			buttons : [{
				text : '保存',
				iconCls : 'save',
				disabled : false,
				handler : function(){
					saveNotice(addNoticeWindow.down('form'), Ext.data.StoreManager.lookup('NoticeStore'));
				}
			}, {
				text : '取消',
				iconCls : 'cancel',
				disabled : false,
				handler : function(){
					addNoticeWindow.hide();
				}
			}]
		}]
	});
	/**
	 * 显示公告的界面
	 */
	var NoticePanel = Ext.create("Ext.grid.Panel", {
		title : '公告管理',//标题
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
						deleteNotice(grid, row, col);
					}
			}]}
		],
		store : Ext.data.StoreManager.lookup('NoticeStore'),
		selType : 'checkboxmodel',
		multiSelect : true,
		tbar : [
			{xtype : 'button', text : '发布', iconCls:'add', style:'margin-left:40px;', handler: function(btn){addNoticeWindow.show();}},
			{xtype : 'button', text : '删除', iconCls:'delete', handler: function(btn){deleteNotices(btn.ownerCt.ownerCt);}}
		],
		dockedItems : [{
			xtype : 'pagingtoolbar',
			store : Ext.data.StoreManager.lookup('NoticeStore'),
			dock : 'bottom',
			displayInfo : true
		}],
		frame : true,
		loadMask : true
	});
	
	/**
	 * 添加仓库的窗体
	 */
	var addLockerWindow = Ext.create('Ext.window.Window', {
		title : '添加仓库',
		width : 350,
		height : 350,
		layout : 'fit',
		plain : true,
		closeAction : 'hide',
		resizable : 'false',
		items : [{
			xtype : 'form',
			frame : true,
			labelAlign : 'left',
			style : 'padding-left:50px;padding-top:10px;',
			defualts : {
				labelSeparator : ' : '
			},
			defaultType : 'textfield',
			items : [{
				fieldLabel : '储物柜编号',
				name : 'locker.id',
				allowBlank : false,
				msgTarget : 'side'
			}, {
				fieldLabel : '存储地',
				name : 'locker.addr',
				allowBlank : false,
				maxLength : 20,
				msgTarget : 'side'
			}, {
				xtype : 'numberfield',
				name : 'locker.capacity',
				value : 1,
				minValue : 1,
				fieldLabel : '容量',
				allowBlank : false,
				msgTarget : 'side'
			}],
			buttons : [{
				text : '保存',
				iconCls : 'save',
				disabled : false,
				handler : function(){
					saveLocker(addLockerWindow.down('form'), Ext.data.StoreManager.lookup('LockerStore'));
				}
			}, {
				text : '取消',
				iconCls : 'cancel',
				disabled : false,
				handler : function(){
					addLockerWindow.hide();
				}
			}]
		}]
	});
	/**
	 * 仓库显示界面
	 */
	var LockerPanel = Ext.create("Ext.grid.Panel", {
		title : '仓库管理',//标题
		width : 900,
		height : 400,
		style : 'margin:10px 12% 0;',
		columns : [
			{xtype : 'rownumberer'},
			{text:'储物柜编号', dataIndex:'id'},
			{text:'仓库', dataIndex:'addr'},
			{text:'仓库容量', dataIndex:'capacity'},
			{text:'已存数量', dataIndex:'nowcapacity'},
			{header : "操作", xtype : 'actioncolumn',
				items : [{
					icon : 'image/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteLocker(grid, row, col);
					}
			}]}
		],
		store : Ext.data.StoreManager.lookup('LockerStore'),
		selType : 'checkboxmodel',
		multiSelect : true,
		tbar : [
			{xtype : 'button', text : '添加', iconCls:'add', style:'margin-left:40px;', handler: function(btn){addLockerWindow.show();}},
			{xtype : 'button', text : '删除', iconCls:'delete', handler: function(btn){deleteLockers(btn.ownerCt.ownerCt);}}
		],
		dockedItems : [{
			xtype : 'pagingtoolbar',
			store : Ext.data.StoreManager.lookup('LockerStore'),
			dock : 'bottom',
			displayInfo : true
		}],
		frame : true,
		loadMask : true
	});
	
	/**
	 * 添加设备和耗材类型的窗体
	 */
	var addTypeWindow = Ext.create('Ext.window.Window', {
		title : '添加设备和耗材类型',
		width : 350,
		height : 350,
		layout : 'fit',
		plain : true,
		closeAction : 'hide',
		resizable : 'false',
		items : [{
			xtype : 'form',
			frame : true,
			labelAlign : 'left',
			style : 'padding-left:50px;padding-top:10px;',
			defualts : {
				labelSeparator : ' : '
			},
			defaultType : 'textfield',
			items : [{
				fieldLabel : '类型编号',
				name : 'type.id',
				allowBlank : false,
				msgTarget : 'side'
			}, {
				fieldLabel : '类型名',
				name : 'type.typename',
				allowBlank : false,
				msgTarget : 'side'
			}, {
				xtype : 'combobox',
				fieldLabel : '是否为耗材',
				name : 'type.iselement',
				allowBlank : false,
				queryMode : 'local',//本地选择模式
				store : Ext.data.StoreManager.lookup('IsOrNot'),
				valueField : 'id',
				value : 0,
				displayField : 'word',
				forceSelection : true,
				typeAhead : true,
				msgTarget : 'side'
			}],
			buttons : [{
				text : '保存',
				iconCls : 'save',
				disabled : false,
				handler : function(){
					saveType(addTypeWindow.down('form'), Ext.data.StoreManager.lookup('TypeStore'));
				}
			}, {
				text : '取消',
				iconCls : 'cancel',
				disabled : false,
				handler : function(){
					addTypeWindow.hide();
				}
			}]
		}]
	});
	/**
	 * 仓库显示界面
	 */
	var TypePanel = Ext.create("Ext.grid.Panel", {
		title : '器件类型管理',//标题
		width : 900,
		height : 400,
		style : 'margin:10px 12% 0;',
		columns : [
			{xtype : 'rownumberer'},
			{text:'类型编号', dataIndex:'id'},
			{text:'类型名', dataIndex:'typename'},
			{text:'是否为耗材', dataIndex:'iselement'},
			{header : "操作", xtype : 'actioncolumn',
				items : [{
					icon : 'image/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteType(grid, row, col);
					}
			}]}
		],
		store : Ext.data.StoreManager.lookup('TypeStore'),
		selType : 'checkboxmodel',
		multiSelect : true,
		tbar : [
			{xtype : 'button', text : '添加', iconCls:'add', style:'margin-left:40px;', handler: function(btn){addTypeWindow.show();}},
			{xtype : 'button', text : '删除', iconCls:'delete', handler: function(btn){deleteTypes(btn.ownerCt.ownerCt);}}
		],
		dockedItems : [{
			xtype : 'pagingtoolbar',
			store : Ext.data.StoreManager.lookup('TypeStore'),
			dock : 'bottom',
			displayInfo : true
		}],
		frame : true,
		loadMask : true
	});
	
	/**
	 * 添加设备和耗材的窗体
	 */
	var addElementWindow = Ext.create('Ext.window.Window', {
		title : '添加设备和耗材',
		width : 350,
		height : 350,
		layout : 'fit',
		plain : true,
		closeAction : 'hide',
		resizable : 'false',
		items : [{
			xtype : 'form',
			frame : true,
			labelAlign : 'left',
			style : 'padding-left:50px;padding-top:10px;',
			defualts : {
				labelSeparator : ' : '
			},
			defaultType : 'textfield',
			items : [{
				fieldLabel : '器件编号',
				name : 'element.id',
				allowBlank : false,
				msgTarget : 'side'
			}, {
				fieldLabel : '器件名称',
				name : 'element.elementname',
				allowBlank : false,
				msgTarget : 'side'
			}, {
				fieldLabel : '封装类型',
				name : 'element.feature',
				allowBlank : false,
				msgTarget : 'side'
			}, {
				xtype : 'combobox',
				fieldLabel : '器件类型',
				maxHeight : 20,
				name : 'element.type.id',
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
				xtype : 'combobox',
				fieldLabel : '存储仓库',
				maxHeight : 20,
				name : 'element.locker.id',
				value : 0,
				allowBlank : false,
				queryMode : 'remote',
				store : Ext.data.StoreManager.lookup('LockerStore'),
				valueField : 'id',
				displayField : 'id',
				forceSelection : true,
				typeAhead : true,
				msgTarget : 'side'
			}, {
				xtype : 'numberfield',
				fieldLabel : '库存',
				value : 0,
				minValue : 0,
				name : 'element.store',
				allowBlank : false,
				msgTarget : 'side'
			}, {
				fieldLabel : '上传照片',
				inputType : 'file',
				name : 'img',
				id : 'img',
				regex : /\.(jpg|gif|bmp|png)/,
				regexText : '图片格式只能为.jpg/.gif/.bmp/.png',
				msgTarget : 'side'
			}, {
				fieldLabel : '上传手册',
				inputType : 'file',
				name : 'manual',
				regex : /\.(doc|docx|pdf|txt)/,
				regexText : '文件格式只能为.doc/.docx/.pdf/.txt',
				msgTarget : 'side'
			}],
			buttons : [{
				text : '保存',
				iconCls : 'save',
				disabled : false,
				handler : function(){
					saveElement(addElementWindow.down('form'), Ext.data.StoreManager.lookup('ElementStore'));
				}
			}, {
				text : '取消',
				iconCls : 'cancel',
				disabled : false,
				handler : function(){
					addElementWindow.hide();
				}
			}]
		}]
	});
	/**
	 * 设备和耗材详情窗体
	 */
	var elementDetailWindow = Ext.create('Ext.window.Window', {
		title : '设备和耗材详情',
		width : 400,
		height : 500,
		layout : 'fit',
		plain : true,
		closeAction : 'hide',
		resizable : 'false',
		items : [{
			xtype : 'form',
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
					elementDetailWindow.hide();
				}
			}],
			frame : true,
			loadMask : true
		}]
	});
	/**
	 * 设备和耗材管理界面
	 */
	var ElementPanel = Ext.create('Ext.grid.Panel', {
		title : '设备与耗材管理',
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
					tooltip : '详情',
					handler : function(grid, row, col){
						showElementDetailWindow(grid, elementDetailWindow.down('form'), row);
						elementDetailWindow.show();
					}
				}, {
					icon : 'image/displayall.ico',
					tooltip : '手册下载',
					handler : function(grid, row, col){
						download4Element(grid, row, col);
					}
				}, {
					icon : 'image/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteElement(grid, row, col);
					}
				}]
			}
		],
		tbar : [
			{xtype : 'button', text : '添加', iconCls:'add', style:'margin-left:40px;', handler: function(btn){addElementWindow.show();}},
			{xtype : 'button', text : '删除', iconCls:'delete', handler: function(btn){deleteElements(btn.ownerCt.ownerCt);}}
		],
		store : Ext.data.StoreManager.lookup('ElementStore'),
		selType : 'checkboxmodel',
		multiSelect : true,
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
	 * 用户管理界面
	 */
	var UserPanel = Ext.create('Ext.grid.Panel', {
		title : '用户管理',
		width : 1000,
		height : 400,
		style : 'margin:10px 8% 0;',
		columns : [
			{xtype : 'rownumberer'},
			{text:'编号', dataIndex:'id', width : 100},
			{text:'用户名', dataIndex:'username', width :100},
			{text:'姓名', dataIndex:'relname', width : 80},
			{text:'职务', dataIndex:'post.postname', width : 60},
			{text:'邮箱', dataIndex:'email', width : 160},
			{text:'电话', dataIndex:'tel', width : 100},
			{text:'注册日期', dataIndex:'regtime', width : 100},
			{text:'班级', dataIndex:'clazz', width : 80},
			{text:'QQ', dataIndex:'qq', width : 80},
			{header : "操作", xtype : 'actioncolumn', width : 80,
				items : [{
					icon : 'image/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteUser(grid, row, col);
					}
				}]
			}
		],
		tbar : [
			{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){deleteUsers(btn.ownerCt.ownerCt);}}
		],
		store : Ext.data.StoreManager.lookup('UserStore'),
		selType : 'checkboxmodel',
		multiSelect : true,
		dockedItems : [{
			xtype : 'pagingtoolbar',
			store : Ext.data.StoreManager.lookup('UserStore'),
			dock : 'bottom',
			displayInfo : true
		}],
		frame : true,
		loadMask : true
	});
	
	/**
	 * 添加用户窗体
	 */
	var addAdminWindow = Ext.create('Ext.window.Window', {
		title : '添加管理员',
		width : 350,
		height : 350,
		layout : 'fit',
		plain : true,
		closeAction : 'hide',
		resizable : 'false',
		items : [{
			xtype : 'form',
			frame : true,
			labelAlign : 'left',
			style : 'padding-left:50px;padding-top:10px;',
			defualts : {
				labelSeparator : ' : '
			},
			defaultType : 'textfield',
			items : [{
				fieldLabel : '用户ID',
				name : 'user.id',
				id : 'userid',
				allowBlank : false,
				maxLength : 8,
				regex : /^[0-9]*$/,
				regexText : '必须为数字组合',
				emptyText : '从10010开始编号',
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
				fieldLabel : '密码',
				name : 'user.password',
				allowBlank : false,
				id : 'password',
				maxLength : 20,
				inputType : 'password',
				regex : /^[\w]{6,}$/,
				regexText : '密码只能包含数字、字母、下划线， ，长度不少于6位',
				msgTarget : 'side'
			}, {
				fieldLabel : '确认密码',
				name : 'user.confirm',
				id : 'confirm',
				allowBlank : false,
				maxLength : 20,
				inputType : 'password',
				regex : /^[\w]{6,}$/,
				regexText : '密码只能包含数字、字母、下划线，长度不少于6位',
				msgTarget : 'side'
			}, {
				fieldLabel : '真实姓名',
				name : 'user.relname',
				id : 'relname',
				allowBlank : false,
				maxLength : 20,
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
				fieldLabel : 'qq',
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
				handler : function(){
					saveAdmin(addAdminWindow.down('form'), Ext.data.StoreManager.lookup('AdminStore'));
				}
			}, {
				text : '取消',
				iconCls : 'cancel',
				disabled : false,
				handler : function(){
					addAdminWindow.hide();
				}
			}]
		}]
	});
	/**
	 * 用户管理界面
	 */
	var AdminPanel = Ext.create('Ext.grid.Panel', {
		title : '管理员管理',
		width : 1000,
		height : 400,
		style : 'margin:10px 8% 0;',
		columns : [
			{xtype : 'rownumberer'},
			{text:'编号', dataIndex:'id', width : 100},
			{text:'用户名', dataIndex:'username', width :100},
			{text:'姓名', dataIndex:'relname', width : 100},
			{text:'邮箱', dataIndex:'email', width : 160},
			{text:'电话', dataIndex:'tel', width : 100},
			{text:'注册日期', dataIndex:'regtime', width : 100},
			{text:'班级', dataIndex:'clazz', width : 100},
			{text:'QQ', dataIndex:'qq', width : 80},
			{header : "操作", xtype : 'actioncolumn', width : 80,
				items : [{
					icon : 'image/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteUser(grid, row, col);
					}
				}]
			}
		],
		tbar : [
			{xtype : 'button', text : '添加', iconCls:'add', style:'margin-left:40px;', handler: function(btn){addAdminWindow.show();	}},
			{xtype : 'button', text : '删除', iconCls:'delete', handler: function(btn){deleteUsers(btn.ownerCt.ownerCt);}}
		],
		store : Ext.data.StoreManager.lookup('AdminStore'),
		selType : 'checkboxmodel',
		multiSelect : true,
		dockedItems : [{
			xtype : 'pagingtoolbar',
			store : Ext.data.StoreManager.lookup('AdminStore'),
			dock : 'bottom',
			displayInfo : true
		}],
		frame : true,
		loadMask : true
	});
		/**
	 * 显示申领记录
	 */
	var BorrowRecordPanel = Ext.create('Ext.tab.Panel', {
		title : '申领记录',
		width : 1000,
		height : 400,
		style : 'margin:10px 8% 0;',
		activeTap : 0,
		items : [{
			title : '已通过',
			xtype : 'gridpanel',
			columns : [
			{xtype : 'rownumberer'},
			{text:'申请人编号', dataIndex:'applicant.id', width : 70},
			{text:'申请人姓名', dataIndex:'applicant.relname', width :70},
			{text:'申请人职务', dataIndex:'applicant.post.postname', width : 80},
			{text:'器件编号', dataIndex:'element.id', width : 80},
			{text:'器件名称', dataIndex:'element.elementname', width : 100},
			{text:'器件类型', dataIndex:'element.type.typename', width : 60},
			{text:'封装类型', dataIndex:'element.feature', width : 65},
			{text:'储物柜', dataIndex:'element.locker.id', width : 50},
			{text:'仓库', dataIndex:'element.locker.addr', width : 50},
			{text:'库存量', dataIndex:'element.store', width : 50, 
				renderer : function(value){
					if(value == 0){
						return '<font color=red>' + value + '</font>';
					} else{
						return '<font color=black>' + value + '</font>';
					}
				}
			},
			{text:'申请数量', dataIndex:'count', width : 60},
			{text:'申请日期', dataIndex:'time', width : 80},
			{text:'审核人', dataIndex:'verifier.relname', width:60},
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
			},
			{header : '操作', xtype : 'actioncolumn', width:60,
				items : [{
					icon : 'image/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deletePassBorrow(grid, row, col);
					}
				}]
			}],
			store : Ext.data.StoreManager.lookup('adminPassBorrowStore'),
			selType : 'checkboxmodel',
			multiSelect : true,
			tbar : [
				{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){deletePassBorrows(btn.ownerCt.ownerCt);}}
			],
			dockedItems : [{
				xtype : 'pagingtoolbar',
				store : Ext.data.StoreManager.lookup('adminPassBorrowStore'),
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
			{text:'申请人编号', dataIndex:'applicant.id', width : 70},
			{text:'申请人姓名', dataIndex:'applicant.relname', width :70},
			{text:'申请人职务', dataIndex:'applicant.post.postname', width : 80},
			{text:'器件编号', dataIndex:'element.id', width : 80},
			{text:'器件名称', dataIndex:'element.elementname', width : 80},
			{text:'器件类型', dataIndex:'element.type.typename', width : 60},
			{text:'封装类型', dataIndex:'element.feature', width : 60},
			{text:'储物柜', dataIndex:'element.locker.id', width : 40},
			{text:'仓库', dataIndex:'element.locker.addr', width : 40},
			{text:'库存量', dataIndex:'element.store', width : 40,
				renderer : function(value){
					if(value == 0){
						return '<font color=red>' + value + '</font>';
					} else{
						return '<font color=black>' + value + '</font>';
					}
				}
			},
			{text:'申请数量', dataIndex:'count', width : 60},
			{text:'申请日期', dataIndex:'time', width : 60},
			{text:'审核人', dataIndex:'verifier.relname', width:60},
			{header : '操作', xtype : 'actioncolumn', width:60,
				items : [{
					icon : 'image/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteRefuseBorrow(grid, row, col);
					}
				}]
			}],
			store : Ext.data.StoreManager.lookup('adminRefuseBorrowStore'),
			selType : 'checkboxmodel',
			multiSelect : true,
			tbar : [
				{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){deleteRefuseBorrows(btn.ownerCt.ownerCt);}}
			],
			dockedItems : [{
				xtype : 'pagingtoolbar',
				store : Ext.data.StoreManager.lookup('adminRefuseBorrowStore'),
				dock : 'bottom',
				displayInfo : true
			}],
			frame : true,
			loadMask : true
		}]
	});
	//为tabpanel添加切换事件
	BorrowRecordPanel.on('tabchange', function(tabPanel, newCard, oldCard){
		if(newCard.title == '已通过')
			Ext.data.StoreManager.lookup('adminPassBorrowStore').load({
				params : {
					start : 0,
					page : 1,
					limit : 15
				}
			});
		else
			Ext.data.StoreManager.lookup('adminRefuseBorrowStore').load({
				params : {
					start : 0,
					page : 1,
					limit : 15
				}
			});
	});
	
	/**
	 * 入库窗体
	 */
	var intoStoreWindow = Ext.create('Ext.window.Window', {
		title : '申购设备入库',
		width : 400,
		height : 500,
		layout : 'fit',
		plain : true,
		closeAction : 'hide',
		resizable : 'false',
		items : [{
			xtype : 'form',
			frame : true,
			labelAlign : 'left',
			style : 'padding-left:50px;padding-top:10px;',
			defualts : {
				labelSeparator : ' : '
			},
			defaultType : 'textfield',
			items : [{
				fieldLabel : '器件编号',
				name : 'element.id',
				allowBlank : false,
				msgTarget : 'side'
			}, {
				fieldLabel : '器件名称',
				name : 'element.elementname',
				readOnly : true,
				allowBlank : false,
				msgTarget : 'side'
			}, {
				fieldLabel : '封装类型',
				name : 'element.feature',
				readOnly : true,
				allowBlank : false,
				msgTarget : 'side'
			}, {
				fieldLabel : '器件类型',
				name : 'element.type.typename',
				readOnly : true,
				allowBlank : false,
				msgTarget : 'side'
			}, {
				fieldLabel : '器件类型编号',
				name : 'element.type.id',
				hidden : true
			}, {
				xtype : 'combobox',
				fieldLabel : '存储仓库',
				maxHeight : 20,
				name : 'element.locker.id',
				value : 0,
				allowBlank : false,
				queryMode : 'remote',
				store : Ext.data.StoreManager.lookup('LockerStore'),
				valueField : 'id',
				displayField : 'id',
				forceSelection : true,
				typeAhead : true,
				msgTarget : 'side'
			}, {
				fieldLabel : '照片',
				name : 'element.img',
				hidden : true
			}, {
				fieldLabel : '上传手册',
				name : 'element.manual',
				hidden : true
			}],
			buttons : [{
				text : '保存',
				iconCls : 'save',
				disabled : false,
				handler : function(){
					saveIntoStore(intoStoreWindow.down('form'));
					intoStoreWindow.hide();
				}
			}, {
				text : '取消',
				iconCls : 'cancel',
				disabled : false,
				handler : function(){
					intoStoreWindow.hide();
				}
			}]
		}]
	});
	/**
	 * 申购详情窗体
	 */
	var porDetailWindow = Ext.create('Ext.window.Window', {
		title : '申购详情',
		width : 400,
		height : 500,
		layout : 'fit',
		plain : true,
		closeAction : 'hide',
		resizable : 'false',
		items : [{
			xtype : 'form',
			labelAlign : 'left',
			style : 'padding-top:10; padding-left:65',
			defualts : {
				labelSeparator : ' : '
			},
			defaultType : 'textfield',
			items :[{
				fieldLabel : '申请人编号',
				name : 'applicant.id',
				readOnly : true
			}, {
				fieldLabel : '申请人姓名', 
				name : 'applicant.relname',
				readOnly : true
			}, {
				fieldLabel : '申请人职务', 
				name : 'applicant.post.postname',
				readOnly : true
			}, {
				fieldLabel : '器件名称', 
				name : 'tempElement.elementname',
				readOnly : true
			}, {
				fieldLabel : '器件类型', 
				name : 'tempElement.type.typename',
				readOnly : true
			}, {
				fieldLabel : '封装类型', 
				name : 'tempElement.feature',
				readOnly : true
			}, {
				fieldLabel : '单价', 
				name : 'tempElement.price',
				readOnly : true
			}, {
				fieldLabel : '数量', 
				name : 'tempElement.count',
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
					elementDetailWindow.hide();
				}
			}],
			frame : true,
			loadMask : true
		}]
	});
	/**
	 * 显示申购记录
	 */
	var PorRecordPanel = Ext.create('Ext.tab.Panel', {
		title : '申购记录',
		width : 1000,
		height : 400,
		style : 'margin:10px 8% 0;',
		activeTap : 0,
		items : [{
			title : '已通过',
			xtype : 'gridpanel',
			columns : [
			{xtype : 'rownumberer'},
			{text:'申请人编号', dataIndex:'applicant.id', width : 80},
			{text:'申请人姓名', dataIndex:'applicant.relname', width :80},
			{text:'申请人职务', dataIndex:'applicant.post.postname', width : 80},
			{text:'器件名称', dataIndex:'tempElement.elementname', width : 115},
			{text:'器件类型', dataIndex:'tempElement.type.typename', width : 80},
			{text:'封装类型', dataIndex:'tempElement.feature', width : 100},
			{text:'单价', dataIndex:'tempElement.price', width : 80},
			{text:'数量', dataIndex:'tempElement.count', width : 80},
			{text:'申请日期', dataIndex:'time', width : 80},
			{text:'审核人', dataIndex:'verifier.relname', width:80},
			{header : '操作', xtype : 'actioncolumn', width:80,
				items : [{
					icon : 'image/look.ico',
					tooltip : '详情',
					handler : function(grid, row, col){
						showPorDetailWindow(grid, porDetailWindow.down('form'), row);
						porDetailWindow.show();
					}
				}, {
					icon : 'image/displayall.ico',
					tooltip : '手册下载',
					handler : function(grid, row, col){
						download4Por(grid, row, col);
					}
				}, {
					icon : 'image/confirm.ico',
					tooltip : '入库',
					handler : function(grid, row, col){
						showIntoStoreWindow(grid, intoStoreWindow.down('form'), row);
						intoStoreWindow.show();
					}
				}, {
					icon : 'image/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deletePassPor(grid, row, col);
					}
				}]
			}],
			store : Ext.data.StoreManager.lookup('adminPassPorStore'),
			selType : 'checkboxmodel',
			multiSelect : true,
			tbar : [
				{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){deletePassPors(btn.ownerCt.ownerCt);}}
			],
			dockedItems : [{
				xtype : 'pagingtoolbar',
				store : Ext.data.StoreManager.lookup('adminPassPorStore'),
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
			{text:'申请人编号', dataIndex:'applicant.id', width : 80},
			{text:'申请人姓名', dataIndex:'applicant.relname', width :80},
			{text:'申请人职务', dataIndex:'applicant.post.postname', width : 80},
			{text:'器件名称', dataIndex:'tempElement.elementname', width : 115},
			{text:'器件类型', dataIndex:'tempElement.type.typename', width : 80},
			{text:'封装类型', dataIndex:'tempElement.feature', width : 100},
			{text:'单价', dataIndex:'tempElement.price', width : 80},
			{text:'数量', dataIndex:'tempElement.count', width : 80},
			{text:'申请日期', dataIndex:'time', width : 80},
			{text:'审核人', dataIndex:'verifier.relname', width:80},
			{header : '操作', xtype : 'actioncolumn', width:80,
				items : [{
					icon : 'image/delete.ico',
					tooltip : '删除',
					handler : function(grid, row, col){
						deleteRefusePor(grid, row, col);
					}
				}]
			}],
			store : Ext.data.StoreManager.lookup('adminRefusePorStore'),
			selType : 'checkboxmodel',
			multiSelect : true,
			tbar : [
				{xtype : 'button', text : '删除', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){deleteRefusePors(btn.ownerCt.ownerCt);}}
			],
			dockedItems : [{
				xtype : 'pagingtoolbar',
				store : Ext.data.StoreManager.lookup('adminRefusePorStore'),
				dock : 'bottom',
				displayInfo : true
			}],
			frame : true,
			loadMask : true
		}]
	});
	//为tabpanel添加切换事件
	PorRecordPanel.on('tabchange', function(tabPanel, newCard, oldCard){
		if(newCard.title == '已通过')
			Ext.data.StoreManager.lookup('adminPassPorStore').load({
				params : {
					start : 0,
					page : 1,
					limit : 15
				}
			});
		else
			Ext.data.StoreManager.lookup('adminRefusePorStore').load({
				params : {
					start : 0,
					page : 1,
					limit : 15
				}
			});
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
	
	/**
	 * 申购详情窗体
	 */
	var changeImageWindow = Ext.create('Ext.window.Window', {
		title : '图片上传',
		width : 250,
		height : 100,
		layout : 'fit',
		plain : true,
		closeAction : 'hide',
		resizable : 'false',
		items : [{
			xtype : 'form',
			labelAlign : 'left',
			style : 'padding-top:10; padding-left:5',
			defualts : {
				labelSeparator : ' : '
			},
			defaultType : 'textfield',
			items :[{
				fieldLabel : '图片',
				labelWidth : 40,
				inputType : 'file',
				name : 'img',
				regex : /\.(png)/,
				regexText : '图片格式只能为.png',
				msgTarget : 'side'
			}, {
				name : 'imageId',
				hidden : true
			}],
			buttons : [{
				text : '确定',
				iconCls : 'save',
				disabled : false,
				handler : function(b){
					changeImage(changeImageWindow.down('form'), ImagePanel, mainPanel);
					changeImageWindow.hide();
				}
			}, {
				text : '取消',
				iconCls : 'cancel',
				disabled : false,
				handler : function(b){
					changeImageWindow.hide();
				}
			}],
			frame : true,
			loadMask : true
		}]
	});
	/**
	 * 显示首页图片
	 */
	var ImagePanel = Ext.create('Ext.tab.Panel', {
		title : '申购记录',
		width : 1000,
		height : 350,
		style : 'margin:10px 8% 0;',
		activeTap : 0,
		items : [{
			title : '图片1',
			xtype : 'panel',
			id : 'panel1',
			items : [{
				xtype : 'image',
				width : 1000,
				height : 220,
				id : 'image1'
			}],
			tbar : [
				{xtype : 'button', text : '更换', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){
					changeImageWindow.down('form').down('[name=imageId]').setValue('1');
					changeImageWindow.show();
					Ext.Msg.alert('提示', '为了保证显示效果，上传图片大小为1000*220像素<br/>图片格式只能为png');
				}}
			],
			frame : true,
			loadMask : true
		}, {
			title : '图片2',
			xtype : 'panel',
			id : 'panel2',
			items : [{
				xtype : 'image',
				width : 1000,
				height : 220,
				id : 'image2'
			}],
			tbar : [
				{xtype : 'button', text : '更换', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){
					changeImageWindow.down('form').down('[name=imageId]').setValue('2');
					changeImageWindow.show();
					Ext.Msg.alert('提示', '为了保证显示效果，上传图片大小为1000*220像素<br/>图片格式只能为png');
				}}
			],
			frame : true,
			loadMask : true
		}, {
			title : '图片3',
			xtype : 'panel',
			id : 'panel3',
			items : [{
				xtype : 'image',
				width : 1000,
				height : 220,
				id : 'image3'
			}],
			tbar : [
				{xtype : 'button', text : '更换', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){
					changeImageWindow.down('form').down('[name=imageId]').setValue('3');
					changeImageWindow.show();
					Ext.Msg.alert('提示', '为了保证显示效果，上传图片大小为1000*220像素<br/>图片格式只能为png');
				}}
			],
			frame : true,
			loadMask : true
		}, {
			title : '图片4',
			xtype : 'panel',
			id : 'panel4',
			items : [{
				xtype : 'image',
				width : 1000,
				height : 220,
				id : 'image4'
			}],
			tbar : [
				{xtype : 'button', text : '更换', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){
					changeImageWindow.down('form').down('[name=imageId]').setValue('4');
					changeImageWindow.show();
					Ext.Msg.alert('提示', '为了保证显示效果，上传图片大小为1000*220像素<br/>图片格式只能为png');
				}}
			],
			frame : true,
			loadMask : true
		}, {
			title : '图片5',
			xtype : 'panel',
			id : 'panel5',
			items : [{
				xtype : 'image',
				width : 1000,
				height : 220,
				id : 'image5'
			}],
			tbar : [
				{xtype : 'button', text : '更换', iconCls:'delete', style:'margin-left:40px;', handler: function(btn){
					changeImageWindow.down('form').down('[name=imageId]').setValue('5');
					changeImageWindow.show();
					Ext.Msg.alert('提示', '为了保证显示效果，上传图片大小为1000*220像素<br/>图片格式只能为png');
				}}
			],
			frame : true,
			loadMask : true
		}]
	});
	
	//为树形菜单增加单击时间，根据id判断要添加的面板
	superAdminMenu.on({
		'itemclick' : function(view, record, item, index, event, options){
			if(record.get('leaf')){
				showModifyUser(record, mainPanel, showUser);
				showModifyPass(record, mainPanel, modifyPass);
				showMyMessage(record, mainPanel, showOldMessage, Ext.data.StoreManager.lookup('userMessageStore'));
				showNoticePanel(record, mainPanel, NoticePanel, Ext.data.StoreManager.lookup('NoticeStore'));
				showLockerPanel(record, mainPanel, LockerPanel, Ext.data.StoreManager.lookup('LockerStore'));
				showTypePanel(record, mainPanel, TypePanel, Ext.data.StoreManager.lookup('TypeStore'));
				showElementPanel(record, mainPanel, ElementPanel, Ext.data.StoreManager.lookup('ElementStore'));
				showUserPanel(record, mainPanel, UserPanel, Ext.data.StoreManager.lookup('UserStore'));
				showAdminPanel(record, mainPanel, AdminPanel, Ext.data.StoreManager.lookup('AdminStore'));
				showBorrowRecordPanel(record, mainPanel, BorrowRecordPanel, Ext.data.StoreManager.lookup('adminPassBorrowStore'));
				showPorRecordPanel(record, mainPanel, PorRecordPanel, Ext.data.StoreManager.lookup('adminPassPorStore'));
				showImagePanel(record, mainPanel, ImagePanel, Ext.data.StoreManager.lookup('ImageStore'));
				//消除HTML div上的内容
				var mainDiv = Ext.getDom('main');
				mainDiv.innerHTML = '';
			}
		}
	});
});