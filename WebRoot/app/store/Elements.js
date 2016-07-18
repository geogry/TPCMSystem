//设备与耗材的数据集合
Ext.create('Ext.data.Store', {
	model : 'ElementX',
	storeId : 'ElementStore',
	proxy : {
		type : 'ajax',
		url : 'common/showElements',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read : 'POST'}
	}
});