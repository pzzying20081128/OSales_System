var base_product_brand_grid_column = {
   record : [
         			  {
                    name : 'name',
					mapping : 'name'
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
                    header : '品牌',
		            width :   200,
		            dataIndex :'name',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		            	if(value==null ){
		            		return value ;
		            	}
		            	 else
		            	 {
		            	   return   value;
		            	 }
		          }
                },
            		 	      			  {
                    header : '状态',
		            width :   200,
		            dataIndex :'status',
		            sortable :  true,
		            renderer : function(value, cellmeta, record, rowIndex, columnIndex, store) {
		            	if(value==null ){
		            		return value ;
		            	}
		            	 else
		            	 {
		            	   return   value;
		            	 }
		          }
                },
            		 	 
	
	
	]
};
////////////////////////////////////////////////////////////////////////////////////

