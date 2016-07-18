//新消息数据集
Ext.create("Ext.data.Store", {
	model : 'Message',
	storeId : 'newMessageStore',
	proxy : {
		type : 'ajax',
		url : 'common/showNewMessage',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read:'POST'}
	}
});