//用户菜单
var userMenu = Ext.create('Ext.tree.Panel', {
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
			text : '器件申领',
			leaf : false,
			children : [{//这里设置了树形菜单的叶子节点
				id : 'listElements',
				text : '器件借用',
				leaf : true//此处是叶子节点的标识
			}, {
				id : 'showUserBorrow',
				text : '申领记录',
				leaf : true
			}, {
				id : 'returnElement',
				text : '设备归还',
				leaf : true
			}]
		}, {
			id : '3',
			text : '器件申购',
			leaf : false,
			children : [{
				id : 'porInput',
				text : '器件申购',
				leaf : true
			}, {
				id : 'showUserPor',
				text : '申购记录',
				leaf : true
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
			userMenu.expandAll();
		}
	}, {
		xtype : 'button',
		id : 'allClose',
		iconCls : 'close',
		text : '全部收起',
		handler : function(){
			userMenu.collapseAll();
		}
	}]
});