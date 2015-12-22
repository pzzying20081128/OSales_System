var base_company_info_grid_column = {
   record : [
         			  {
                    name : 'shortName',
					mapping : 'shortName'
                },
		 			  {
                    name : 'name',
					mapping : 'name'
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
                    name : 'orderPhone',
					mapping : 'orderPhone'
                },
		 			  {
                    name : 'fax',
					mapping : 'fax'
                },
		 			  {
                    name : 'web',
					mapping : 'web'
                },
		 			  {
                    name : 'mail',
					mapping : 'mail'
                },
		 			  {
                    name : 'bank',
					mapping : 'bank'
                },
		 			  {
                    name : 'bankNum',
					mapping : 'bankNum'
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
                    header : '简称',
		            width :   200,
		            dataIndex :'shortName',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '单位名字',
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
                    header : '单位地址',
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
                    header : '订货电话',
		            width :   200,
		            dataIndex :'orderPhone',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '传真',
		            width :   200,
		            dataIndex :'fax',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '网页',
		            width :   200,
		            dataIndex :'web',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '电子邮箱',
		            width :   200,
		            dataIndex :'mail',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '银行',
		            width :   200,
		            dataIndex :'bank',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
 return value ;
						 
		          }
                },
            		 	      			  {
                    header : '银行帐号',
		            width :   200,
		            dataIndex :'bankNum',
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

