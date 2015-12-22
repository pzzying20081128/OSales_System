var stock_contract_grid_column = {
   record : [
         			  {
                    name : 'providerInfo.name',
					mapping : 'providerInfo'
                },
		 			  {
                    name : 'providerInfoId',
					mapping : 'providerInfoId'
                },
		 			  {
                    name : 'stockMan.name',
					mapping : 'stockMan'
                },
		 			  {
                    name : 'stockManId',
					mapping : 'stockManId'
                },
		 			  {
                    name : 'companyGuest.name',
					mapping : 'companyGuest'
                },
		 			  {
                    name : 'companyGuestId',
					mapping : 'companyGuestId'
                },
		 			  {
                    name : 'contractStatus',
					mapping : 'contractStatus'
                },
		 			  {
                    name : 'text',
					mapping : 'text'
                },
		 			  {
                    name : 'signedDate',
					mapping : 'signedDate'
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
                    header : '供应商',
		            width :   200,
		            dataIndex :'providerInfo.name',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
if(value.name==null ||  typeof(value.name) =='undefined' )   
  return null   
   else  
 return value.name ;
						 
		          }
                },
            		 	      		 	      			  {
                    header : '采购员',
		            width :   200,
		            dataIndex :'stockMan.name',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
if(value.name==null ||  typeof(value.name) =='undefined' )   
  return null   
   else  
 return value.name ;
						 
		          }
                },
            		 	      		 	      			  {
                    header : '公司名称',
		            width :   200,
		            dataIndex :'companyGuest.name',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		    
						   if(value==null ||  typeof(value) =='undefined' )   
  return null   
   else  
if(value.name==null ||  typeof(value.name) =='undefined' )   
  return null   
   else  
 return value.name ;
						 
		          }
                },
            		 	      		 	      			  {
                    header : '合同类型',
		            width :   200,
		            dataIndex :'contractStatus',
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
                    header : '签订日期',
		            width :   200,
		            dataIndex :'signedDate',
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

