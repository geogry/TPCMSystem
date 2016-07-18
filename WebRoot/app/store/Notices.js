//公告的数据集合
Ext.create('Ext.data.Store', {
	model : 'Notice',
	storeId : 'NoticeStore',
	proxy : {
		type : 'ajax',
		url : 'superadmin/showNotices',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read : 'POST'}
	}
});