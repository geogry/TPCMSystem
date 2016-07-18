//管理员的数据集
Ext.create("Ext.data.Store", {
	model : 'User',
	storeId : 'AdminStore',
	proxy : {
		type : 'ajax',
		url : 'superadmin/showAdmins',
		reader : {
			type : 'json',
			root : 'list',
			success : "@success",
			totalProperty : 'totalCount'
		},
		writer : {
			type : 'json'
		}
	}
});