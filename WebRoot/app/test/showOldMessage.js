Ext.onReady(function(){
	Ext.QuickTips.init();
	
	Ext.create("Ext.grid.Panel", {
		title : '我的消息',//标题
		width : 900,
		height : 400,
		renderTo : Ext.getBody(),
		columns : [
			{text:'编号', dataIndex:'id', hidden: true, width : 100},
			{text:'内容', dataIndex:'content', width : 550},
			{text:'时间', dataIndex:'time', width : 100},
			{text:'操作', width : 100}
		],
		store : Ext.data.StoreManager.lookup('userMessageStore'),
		selType : 'checkboxmodel',
		multiSelect : true,
		tbar : [
			{xtype : 'button', text : '添加'},
			{xtype : 'button', text : '删除'},
			{xtype : 'button', text : '修改'},
			{xtype : 'button', text : '查看'}
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
});