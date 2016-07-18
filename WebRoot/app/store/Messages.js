//用户消息数据集
Ext.create("Ext.data.Store", {
	model : 'Message',
	storeId : 'userMessageStore',
	proxy : {
		type : 'ajax',
		url : 'common/showOldMessage',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read:'POST'}
	}
});