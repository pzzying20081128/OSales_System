var base_store_info_grid_column = {
   record : [
         			  {
                    name : 'name',
					mapping : 'name'
                },
		 			  {
                    name : 'storeType',
					mapping : 'storeType'
                },
		 			  {
                    name : 'address',
					mapping : 'address'
                },
		 			  {
                    name : 'phone',
					mapping : 'phone'
                },
		 			  {
                    name : 'text',
					mapping : 'text'
                },
		 			  {
                    name : 'status',
					mapping : 'status'
                },
		    ],
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	column : [
	 new Ext.grid.ERPRowNumberer(),
	   	      			  {
                    header : '仓库名称',
		            width :   200,
		            dataIndex :'name',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '仓库类型',
		            width :   200,
		            dataIndex :'storeType',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '仓库地址',
		            width :   200,
		            dataIndex :'address',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '联系电话',
		            width :   200,
		            dataIndex :'phone',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '备注',
		            width :   200,
		            dataIndex :'text',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '状态',
		            width :   200,
		            dataIndex :'status',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	 
	
	
	]
};
////////////////////////////////////////////////////////////////////////////////////

