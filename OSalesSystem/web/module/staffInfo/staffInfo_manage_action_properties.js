var staffInfo_manage_grid_column = {
//	record : [{
//		name : 'id'
//	}, {
//		name : 'name'
//	}, {
//		name : 'job'
//	}, {
//		name : 'sex'
//	}, {
//		name : 'access'
//	}, {
//		name : 'departmentParents.name',
//		mapping : "departmentParents"
//	}],
	
   record : [
         			  {
                    name : 'id',
					mapping : 'id'
                },
		 			  {
                    name : 'name',
					mapping : 'name'
                },
		 			  {
                    name : 'sex',
					mapping : 'sex'
                },
		 			  {
                    name : 'phone',
					mapping : 'phone'
                },
		 			  {
                    name : 'cell',
					mapping : 'cell'
                },
		 			  {
                    name : 'address',
					mapping : 'address'
                },
		 			  {
                    name : 'isStock',
					mapping : 'isStock'
                },
		 			  {
                    name : 'isBiz',
					mapping : 'isBiz'
                },
		 			  {
                    name : 'isTransportContactMan',
					mapping : 'isTransportContactMan'
                },
		 			  {
                    name : 'isGoodsMan',
					mapping : 'isGoodsMan'
                },
		 			  {
                    name : 'isDistributionMan',
					mapping : 'isDistributionMan'
                },
		    ],
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	column : [
	 new Ext.grid.ERPRowNumberer(),
	   	      		 	      			  {
                    header : '姓名',
		            width :   200,
		            dataIndex :'name',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		            	if(value==null ){
		            		return value ;
		            	}
		            	 else
		            	 {
		            	     value;
		            	 }
		          }
                },
            		 	      			  {
                    header : '性别',
		            width :   200,
		            dataIndex :'sex',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		            	if(value==null ){
		            		return value ;
		            	}
		            	 else
		            	 {
		            	     value;
		            	 }
		          }
                },
            		 	      			  {
                    header : '手机',
		            width :   200,
		            dataIndex :'phone',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		            	if(value==null ){
		            		return value ;
		            	}
		            	 else
		            	 {
		            	     value;
		            	 }
		          }
                },
            		 	      			  {
                    header : '联系电话',
		            width :   200,
		            dataIndex :'cell',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		            	if(value==null ){
		            		return value ;
		            	}
		            	 else
		            	 {
		            	     value;
		            	 }
		          }
                },
            		 	      			  {
                    header : '地址',
		            width :   200,
		            dataIndex :'address',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		            	if(value==null ){
		            		return value ;
		            	}
		            	 else
		            	 {
		            	     value;
		            	 }
		          }
                },
            		 	      			  {
                    header : '是否采购员',
		            width :   200,
		            dataIndex :'isStock',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		            	if(value==null ){
		            		return value ;
		            	}
		            	 else
		            	 {
		            	     value;
		            	 }
		          }
                },
            		 	      			  {
                    header : '是否业务员',
		            width :   200,
		            dataIndex :'isBiz',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		            	if(value==null ){
		            		return value ;
		            	}
		            	 else
		            	 {
		            	     value;
		            	 }
		          }
                },
            		 	      			  {
                    header : '是否运输员',
		            width :   200,
		            dataIndex :'isTransportContactMan',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		            	if(value==null ){
		            		return value ;
		            	}
		            	 else
		            	 {
		            	     value;
		            	 }
		          }
                },
            		 	      			  {
                    header : '是否理货员',
		            width :   200,
		            dataIndex :'isGoodsMan',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		            	if(value==null ){
		            		return value ;
		            	}
		            	 else
		            	 {
		            	     value;
		            	 }
		          }
                },
            		 	      			  {
                    header : '是否配货员',
		            width :   200,
		            dataIndex :'isDistributionMan',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		            	if(value==null ){
		            		return value ;
		            	}
		            	 else
		            	 {
		            	     value;
		            	 }
		          }
                },
            		 	 
	
	
	]
};
////////////////////////////////////////////////////////////////////////////////////

