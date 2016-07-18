//显示或隐藏修改用户信息面板
var showModifyUser = function(record, mainPanel, showUser){
	if(record.get('id')=='showUser'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(showUser).doLayout();
		showUser.show();
		showUser.form.load({
			url : 'common/showUser',
			method : 'POST',
			waitMsg : '数据正在加载...',
			waitTitle : '请稍后',
			timeout : 10,
			failure : function(form, action){
				Ext.Msg.alert('信息', '数据加载失败！');
			}
		});
	} else {
		showUser.hide();
	}
};
//显示或隐藏修改密码面板
var showModifyPass = function(record, mainPanel, modifyPass){
	if(record.get('id')=='modifyPass'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(modifyPass).doLayout();
		modifyPass.show();
	} else {
		modifyPass.hide();
	}
};
//显示或隐藏用户消息面板
var showMyMessage = function(record, mainPanel, showOldMessage, store){
	if(record.get('id')=='MessageManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(showOldMessage).doLayout();
		showOldMessage.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	} else {
		showOldMessage.hide();
	}
};
//显示或隐藏公告面板
var showNoticePanel = function(record, mainPanel, NoticePanel, store){
	if(record.get('id')=='NoticeManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(NoticePanel).doLayout();
		NoticePanel.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	} else {
		NoticePanel.hide();
	}
};
//显示或隐藏仓库管理面板
var showLockerPanel = function(record, mainPanel, LockerPanel, store){
	if(record.get('id')=='LockerManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(LockerPanel).doLayout();
		LockerPanel.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	} else {
		LockerPanel.hide();
	}
};
//显示或隐藏器件类型管理面板
var showTypePanel = function(record, mainPanel, TypePanel, store){
	if(record.get('id')=='TypeManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(TypePanel).doLayout();
		TypePanel.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	} else {
		TypePanel.hide();
	}
};
//显示或隐藏设备和耗材管理面板
var showElementPanel = function(record, mainPanel, ElementPanel, store){
	if(record.get('id')=='ElementManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(ElementPanel).doLayout();
		ElementPanel.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	} else {
		ElementPanel.hide();
	}
};
//显示或隐藏用户管理面板
var showUserPanel = function(record, mainPanel, UserPanel, store){
	if(record.get('id')=='UserManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(UserPanel).doLayout();
		UserPanel.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	} else {
		UserPanel.hide();
	}
};
//显示或隐藏管理员管理面板
var showAdminPanel = function(record, mainPanel, AdminPanel, store){
	if(record.get('id')=='ManagerManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(AdminPanel).doLayout();
		AdminPanel.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	} else {
		AdminPanel.hide();
	}
};
//显示或隐藏申领记录面板
var showBorrowRecordPanel = function(record, mainPanel, BorrowRecordPanel, store){
	if(record.get('id') == 'BorrowManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(BorrowRecordPanel).doLayout();
		BorrowRecordPanel.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	}else{
		BorrowRecordPanel.hide();
	}
};
//显示或隐藏申领记录面板
var showPorRecordPanel = function(record, mainPanel, PorRecordPanel, store){
	if(record.get('id') == 'PorManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(PorRecordPanel).doLayout();
		PorRecordPanel.show();
		store.load({
			params : {
				start : 0,
				page : 1,
				limit : 15
			}
		});
	}else{
		PorRecordPanel.hide();
	}
};
//显示或隐藏申领记录面板
var showImagePanel = function(record, mainPanel, ImagePanel, store){
	if(record.get('id') == 'ImageManage'){
		mainPanel.setTitle(record.get('text'));
		mainPanel.add(ImagePanel).doLayout();
		ImagePanel.show();
		store.load({
			callback : function(records, options, success){
				if(success == true){
					ImagePanel.down('[id=panel1]').down('[id=image1]').setSrc('image/'+store.getAt(0).get('imagename'));
					ImagePanel.down('[id=panel2]').down('[id=image2]').setSrc('image/'+store.getAt(1).get('imagename'));
					ImagePanel.down('[id=panel3]').down('[id=image3]').setSrc('image/'+store.getAt(2).get('imagename'));
					ImagePanel.down('[id=panel4]').down('[id=image4]').setSrc('image/'+store.getAt(3).get('imagename'));
					ImagePanel.down('[id=panel5]').down('[id=image5]').setSrc('image/'+store.getAt(4).get('imagename'));
				}
			}
		});
	}else{
		ImagePanel.hide();
	}
};

//点击保存按钮之后，保存用户信息
var saveModifyUser = function(form) {
	if(form.form.isValid()){
		Ext.MessageBox.confirm('信息','确定要修改你的资料吗？', function(opt){
			if(opt == 'yes'){
				form.form.submit({
					url : 'common/modifyUser',
					method : 'POST',
					success : function(form, action){
						Ext.Msg.alert('信息', '修改成功！');
					},
					failure : function(form, action){
						Ext.Msg.alert('信息', '修改失败，请重新再试！');
					}
				});
			}
		});
	} else {
		Ext.Msg.alert('提示', '请正确填写你的信息！');
	}
};
//修改密码
var modifyPassword = function(form){
	if(form.form.isValid()){
		Ext.Msg.confirm('提示', '确定要修改你的密码吗？', function(opt){
			if(opt == 'yes'){
				form.form.submit({
					url : 'common/modifyPass',
					method : 'POST',
					success : function(form, action){
						Ext.Msg.alert('信息', '密码修改成功，请牢记你的新密码');
					},
					failure : function(form, action){
						Ext.Msg.alert('信息', '密码修改失败，' + action.result.errorMessage);
					}
				});
			}
		});
	} else {
		Ext.Msg.alert('警告', '请正确填写密码后再提交');
	}
};
//删除选中的消息
var deleteMessages = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的数据！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
					grid.getStore().remove(record[i]);
				}
		
				Ext.Ajax.request({
					url : 'common/deleteMessage',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//删除一条消息
var deleteMessage = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'common/deleteMessage',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
//删除一条消息
var checkMessage = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	var selectIds = record.get('id');
	
	Ext.Ajax.request({
		url : 'common/checkMessage',
		params : {selectIds : selectIds},
		method : 'POST',
		timeout : 10000,
		success : function(response){
			grid.getStore().remove(record);
		},
		failure : function(response){
			Ext.Msg.alert('信息', '删除失败，请重试...');
		}
	});
};
//标记选中的设备
var checkMessages = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要标记的数据！');
	}else{
		var selectIds = '';
		for(var i = 0; i < record.length; i++){
			if(i == 0){
				selectIds += record[i].get('id');
			} else {
				selectIds += ',' + record[i].get('id');
			}
		}

		Ext.Ajax.request({
			url : 'common/checkMessage',
			params : {selectIds : selectIds},
			method : 'POST',
			timeout : 10000,
			success : function(response){
				for(var i = 0; i < record.length; i++){
					grid.getStore().remove(record[i]);
				}
			},
			failure : function(response){
				Ext.Msg.alert('信息', '标记失败，请重试...');
			}
		});
	}
};
//删除选中的消息
var deleteLockers = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的数据！');
	}else{
		Ext.Msg.confirm('提示', '删除记录会级联删除该储物柜下的所有设备和耗材<br/>确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
					grid.getStore().remove(record[i]);
				}
		
				Ext.Ajax.request({
					url : 'superadmin/deleteLocker',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//删除一条消息
var deleteLocker = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '删除这条记录会级联删除该储物柜下的所有设备和耗材<br/>确定要删除吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'superadmin/deleteLocker',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
//保存仓库信息
var saveLocker = function(lockerForm, store){
	if(lockerForm.form.isValid()){
		lockerForm.form.submit({
			url : 'superadmin/addLocker',
			success : function(form, action){
				Ext.Msg.alert('信息', '保存成功！');
				store.load();
				lockerForm.form.reset();
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '保存失败，请重新再试！');
			}
		});
	} else{
		Ext.Msg.alert('警告', '请填写正确的类别信息');
	}
};
//删除选中的用户
var deleteUsers = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的数据！');
	}else{
		Ext.Msg.confirm('提示', '删除记录会级联删除该该用户所有的操作<br/>确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'superadmin/deleteUser',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//删除一条用户
var deleteUser = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '删除这条记录会级联删除该用户的所有操作<br/>确定要删除吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'superadmin/deleteUser',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
//保存管理员信息
var saveAdmin = function(adminForm, store){
	if(adminForm.form.isValid()){
		var passwordTxt = adminForm.getChildByElement('password');
		var confirmTxt = adminForm.getChildByElement('confirm');
		
		if(passwordTxt.getValue() != confirmTxt.getValue()){
			Ext.Msg.alert('错误', '密码不匹配，请重新输入！');
			passwordTxt.setValue('');
			confirmTxt.setValue('');
		} else {
			adminForm.form.submit({
				url : 'superadmin/addAdmin',
				success : function(form, action){
					Ext.Msg.alert('信息', '保存成功！');
					store.load();
					adminForm.form.reset();
				},
				failure : function(form, action){
					Ext.Msg.alert('信息', '保存失败，请重新再试！');
				}
			});
		}
	} else{
		Ext.Msg.alert('警告', '请填写正确的管理员信息');
	}
};
//保存设备和耗材类别信息
var saveType = function(typeForm, store){
	if(typeForm.form.isValid()){
		typeForm.form.submit({
			url : 'superadmin/addType',
			success : function(form, action){
				Ext.Msg.alert('信息', '保存成功！');
				store.load();
				typeForm.form.reset();
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '保存失败，请重新再试！');
			}
		});
	} else{
		Ext.Msg.alert('警告', '请填写正确的类别信息');
	}
};
//删除选中的设备和耗材类型
var deleteTypes = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的数据！');
	}else{
		Ext.Msg.confirm('提示', '删除记录会级联删除所有该类型的器件和耗材<br/>确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
				
				Ext.Ajax.request({
					url : 'superadmin/deleteType',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//删除一个设备或耗材类型
var deleteType = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '删除这条记录会级联删除所有该类型的设备和耗材<br/>确定要删除吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'superadmin/deleteType',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
//删除选中的设备和耗材
var deleteElements = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的数据！');
	}else{
		Ext.Msg.confirm('提示', '删除记录会级联删除所有该类型的器件和耗材<br/>确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
				
				Ext.Ajax.request({
					url : 'superadmin/deleteElement',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//删除一个设备或耗材
var deleteElement = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '删除这条记录会级联删除所有该类型的设备和耗材<br/>确定要删除吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'superadmin/deleteElement',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
//删除通过的借用消息
var deletePassBorrow = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	if(record.get('returned') == 0){
		Ext.Msg.alert('警告', '用户还没有归还设备，不能删除该记录！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				if(record.get('returned') == 1){
					var selectIds = record.get('id');
				}else{
					Ext.Msg.alert('警告', '选择的记录中含有设备未归还的记录，删除失败！');
					return;
				}
				
				Ext.Ajax.request({
					url : 'common/deletePassBorrow',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						grid.getStore().remove(record);
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//删除选中的通过申领信息
var deletePassBorrows = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的数据！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(record[i].get('returned') == 1){
						if(i == 0){
							selectIds += record[i].get('id');
						} else {
							selectIds += ',' + record[i].get('id');
						}
					}else{
						Ext.Msg.alert('警告', '选择的记录中含有设备未归还的记录，删除失败！');
						return;
					}
				}
		
				Ext.Ajax.request({
					url : 'common/deletePassBorrow',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//删除拒绝的借用消息
var deleteRefuseBorrow = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'common/deleteRefuseBorrow',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
//删除选中的拒绝申领信息
var deleteRefuseBorrows = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的数据！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'common/deleteRefuseBorrow',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//删除拒绝的借用消息
var deleteRefusePor = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'common/deleteRefusePor',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
//删除选中的拒绝申领信息
var deleteRefusePors = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的数据！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'common/deleteRefusePor',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//删除拒绝的借用消息
var deletePassPor = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'superadmin/deletePassPor',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
//删除选中的拒绝申领信息
var deletePassPors = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的数据！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'superadmin/deletePassPor',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//删除选中的公告
var deleteNotice = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
		if(opt == 'yes'){
			var selectIds = record.get('id');
			
			Ext.Ajax.request({
				url : 'superadmin/deleteNotice',
				params : {selectIds : selectIds},
				method : 'POST',
				timeout : 10000,
				success : function(response){
					Ext.Msg.alert('信息', '删除成功！');
					grid.getStore().remove(record);
				},
				failure : function(response){
					Ext.Msg.alert('信息', '删除失败，请重试...');
				}
			});
		}
	});
};
//批量删除公告
var deleteNotices = function(grid){
	var record = grid.getSelectionModel().getSelection();
	if(record.length == 0){
		Ext.Msg.alert('提示', '没有选择要删除的数据！');
	}else{
		Ext.Msg.confirm('提示', '确定要删除吗？', function(opt){
			if(opt == 'yes'){
				var selectIds = '';
				for(var i = 0; i < record.length; i++){
					if(i == 0){
						selectIds += record[i].get('id');
					} else {
						selectIds += ',' + record[i].get('id');
					}
				}
		
				Ext.Ajax.request({
					url : 'superadmin/deleteNotice',
					params : {selectIds : selectIds},
					method : 'POST',
					timeout : 10000,
					success : function(response){
						Ext.Msg.alert('信息', '删除成功！');
						for(var i = 0; i < record.length; i++){
							grid.getStore().remove(record[i]);
						}
					},
					failure : function(response){
						Ext.Msg.alert('信息', '删除失败，请重试...');
					}
				});
			}
		});
	}
};
//保存公告
var saveNotice = function(noticeForm, store){
	if(noticeForm.down('htmleditor').getValue() != '<br>' && noticeForm.down('htmleditor').getValue() != ''){
		noticeForm.form.submit({
			url : 'superadmin/addNotice',
			success : function(form, action){
				Ext.Msg.alert('信息', '保存成功！');
				store.load();
				noticeForm.form.reset();
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '保存失败，请重新再试！');
			}
		});
	} else{
		Ext.Msg.alert('警告', '请填写内容');
	}
};
//保存设备和耗材信息
var saveElement = function(elementForm, store){
	if(elementForm.form.isValid()){
		elementForm.form.submit({
			url : 'superadmin/addElement',
			waitMsg : '保存中，请稍后...',
			success : function(form, action){
				Ext.Msg.alert('信息', '保存成功！');
				store.load();
				elementForm.form.reset();
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '保存失败，请重新再试！');
			}
		});
	} else{
		Ext.Msg.alert('警告', '请正确填写设备和耗材信息');
	}
};
//显示设备和耗材详情窗体
var showElementDetailWindow = function(grid, form, row){
	var record = grid.getStore().getAt(row);
	
	form.getForm().findField('id').setValue(record.get('id'));
	form.getForm().findField('elementname').setValue(record.get('elementname'));
	form.getForm().findField('typename').setValue(record.get('type.typename'));
	form.getForm().findField('feature').setValue(record.get('feature'));
	form.getForm().findField('store').setValue(record.get('store'));
	form.getForm().findField('lockAddr').setValue(record.get('locker.addr'));
	form.getForm().findField('locker').setValue(record.get('locker.id'));
	if(record.get('img') != '')
		form.down('image').setSrc('uploads/' + record.get('img'));
};
//显示申购详情窗体
var showPorDetailWindow = function(grid, form, row){
	var record = grid.getStore().getAt(row);
	
	form.down('[name=applicant.id]').setValue(record.get('applicant.id'));
	form.down('[name=applicant.relname]').setValue(record.get('applicant.relname'));
	form.down('[name=applicant.post.postname]').setValue(record.get('applicant.post.postname'));
	form.down('[name=tempElement.elementname]').setValue(record.get('tempElement.elementname'));
	form.down('[name=tempElement.type.typename]').setValue(record.get('tempElement.type.typename'));
	form.down('[name=tempElement.feature]').setValue(record.get('tempElement.feature'));
	form.down('[name=tempElement.price]').setValue(record.get('tempElement.price'));
	form.down('[name=tempElement.count]').setValue(record.get('tempElement.count'));
	if(record.get('tempElement.img') != '')
		form.down('image').setSrc('uploads/' + record.get('tempElement.img'));
};
var download4Por = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	var filename = record.get('tempElement.manual');
	if(filename != '')
		window.location.href = 'uploads/' + filename;
	else
		Ext.Msg.alert('信息', '该设备没有手册！');
};
var download4Element = function(grid, row, col){
	var record = grid.getStore().getAt(row);
	var filename = record.get('manual');
	if(filename != '')
		window.location.href = 'uploads/' + filename;
	else
		Ext.Msg.alert('信息', '该设备没有手册！');
};
var showIntoStoreWindow = function(grid, form, row){
	var record = grid.getStore().getAt(row);
	
	form.down('[name=element.elementname]').setValue(record.get('tempElement.elementname'));
	form.down('[name=element.type.typename]').setValue(record.get('tempElement.type.typename'));
	form.down('[name=element.feature]').setValue(record.get('tempElement.feature'));
	form.down('[name=element.type.id]').setValue(record.get('tempElement.type.id'));
	if(record.get('tempElement.img'))
		form.down('[name=element.img]').setValue(record.get('tempElement.img'));
	if(record.get('tempElement.manual'))
		form.down('[name=element.manual]').setValue(record.get('tempElement.manual'));
};
//保存转储信息
var saveIntoStore = function(intoStoreForm){
	if(intoStoreForm.form.isValid()){
		intoStoreForm.form.submit({
			url : 'superadmin/intoStore',
			waitMsg : '保存中，请稍后...',
			success : function(form, action){
				Ext.Msg.alert('信息', '保存成功！');
				intoStoreForm.form.reset();
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '保存失败，请重新再试！');
			}
		});
	} else{
		Ext.Msg.alert('警告', '请正确填写设备和耗材信息');
	}
};
//更换图片
var changeImage = function(imageForm, ImagePanel){
	var image = ImagePanel.getActiveTab().down('image');
	if(imageForm.form.isValid()){
		imageForm.form.submit({
			url : 'superadmin/changeImage',
			waitMsg : '更换中...',
			success : function(form, action){
				Ext.Msg.alert('信息', '更换成功！');
				imageForm.form.reset();
				image.setSrc('image/' + action.result.imageName);
			},
			failure : function(form, action){
				Ext.Msg.alert('信息', '更换失败，请重新再试！');
			}
		});
	}
};