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
			text : '使用者管理',
			leaf : false,
			children : [{
				id : 'UserManage',
				text : '用户管理',
				leaf : 'true'
			}, {
				id : 'ManagerManage',
				text : '管理员管理',
				leaf : 'true'
			}]
		}, {
			id: '3',
			text : '器件管理',
			leaf : false,
			children : [{//这里设置了树形菜单的叶子节点
				id : 'ElementManage',
				text : '设备与耗材管理',
				leaf : true//此处是叶子节点的标识
			}, {
				id : 'TypeManage',
				text : '器件类型管理',
				leaf : true
			}, {
				id : 'LockerManage',
				text : '仓库管理',
				leaf : true
			}]
		}, {
			id : '4',
			text : '申请记录管理',
			leaf : false,
			children : [{
				id : 'BorrowManage',
				text : '申领记录管理',
				leaf : true
			}, {
				id : 'PorManage',
				text : '申购记录管理',
				leaf : true
			}]
		}, {
			id : 'ImageManage',
			text : '首页图片管理',
			leaf : true
		}, {
			id : 'NoticeManage',
			text : '公告管理',
			leaf : true
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