//用户菜单
var superAdminMenu = Ext.create('Ext.tree.Panel', {
	animate : true,
	frame : true,
	rootVisible : false,
	lines : true,
	width : 200,
	height :450,
	root : {//设置树形菜单的根
		text : '功能菜单',
		id : '0',
		expanded : true,
		leaf : false,
		children :[{//设置树形节点的第一级分支
			text : '我的资料',
			id : 'showUser',
			leaf : true
		}, {
			id: '2',
			text : '申请审核',
			leaf : false,
			children : [{
				id : 'UserCheck',
				text : '用户审核',
				leaf : 'true'
			}, {
				id : 'BorrowCheck',
				text : '申领审核',
				leaf : 'true'
			}, {
				id : 'PorCheck',
				text : '申购审核',
				leaf : 'true'
			}]
		}, {
			id: '3',
			text : '审核记录',
			leaf : false,
			children : [{
				id : 'BorrowRecord',
				text : '申领记录',
				leaf : 'true'
			}, {
				id : 'PorRecord',
				text : '申购记录',
				leaf : 'true'
			}]
		}, {
			id : 'MessageManage',
			text : '我的消息',
			leaf : true
		}, {
			id : 'modifyPass',
			text : '修改密码',
			leaf : true
		}]
	},
	tbar : [{//设置工具条
		xtype : 'button',
		id : 'allOpen',
		iconCls : 'open',
		text : '全部展开',
		handler : function(){
			superAdminMenu.expandAll();
		}
	}, {
		xtype : 'button',
		id : 'allClose',
		iconCls : 'close',
		text : '全部收起',
		handler : function(){
			superAdminMenu.collapseAll();
		}
	}]
});