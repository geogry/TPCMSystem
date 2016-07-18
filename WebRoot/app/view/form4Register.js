//用户注册界面
Ext.onReady(function(){
	Ext.QuickTips.init();
	
	var form4Register = Ext.create('Ext.form.Panel', {
		id : 'form4register',
		renderTo : 'register',
		title : '用户注册',
		bodyStyle : 'padding:100px 5px 0',
		frame : true,
		height : '100%',
		buttonAlign : 'center',
		labelAlign : 'left',
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
			xtype : 'combobox',
			fieldLabel : '职务',
			name : 'user.post.id',
			id : 'postid',
			allowBlank : false,
			listConfig : {
				emptyText : '请选择'
			},
			queryMode : 'local',//本地选择模式
			store : Ext.data.StoreManager.lookup('PostStore'),
			valueField : 'id',
			displayField : 'postname',
			forceSelection : true,
			typeAhead : true,
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
			style : 'top:0;margin-bottom:200px;margin-left:200px;',
			handler : function(){
				save(form4Register);
			}
		}, {
			text : '返回',
			iconCls : 'back',
			disabled : false,
			style : 'top:0;margin-bottom:200px;',
			handler : function(){
				back();
			}
		}]
	});
});