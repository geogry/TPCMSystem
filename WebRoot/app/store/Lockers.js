//设备与耗材的数据集合
Ext.create('Ext.data.Store', {
	model : 'Locker',
	storeId : 'LockerStore',
	proxy : {
		type : 'ajax',
		url : 'superadmin/showLockers',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read : 'POST'}
	}
});