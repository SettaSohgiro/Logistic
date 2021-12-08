	<table>
		
		<tr>
			
                    <td style="width:100px">
                        <img src="http://localhost:8090/LogisticFV/views/image/logo.png" style="width: 150px;">                    
                    </td>

			<td style="background-color:white; width:140px;">
				
				<div style="font-size:8.5px; text-align:center; line-height:15px;">					
					<br>
					RUC: 20517896312

					<br>
					Dirección: Av. Petit Thouars 1931 - Lince

				</div>

			</td>

			<td style="background-color:white; width:160px;text-align:center;">

				<div style="font-size:8.5px; text-align:center; line-height:18px;">
					
					<br>
					Teléfono: 940-120-981
					
					<br>
					Email: almacennbnetg@gmail.com

				</div>
				
			</td>

			<td style="background-color:white; width:150px; text-align:center; color:black;"><br>FACTURA <br> NRO: $valorVenta</td>

		</tr>

	</table>



	<table style="font-size:10px; padding:5px 10px;">
	
		<tr>
		
			<td style="border: 1px solid #666; background-color:white; width:390px">

				Cliente: $respuestaCliente[nombre]

			</td>

			<td style="border: 1px solid #666; background-color:white; width:150px; text-align:right">
			
				Fecha: $fecha

			</td>

		</tr>

		<tr>
		
			<td style="border: 1px solid #666; background-color:white; width:540px">Vendedor: $respuestaVendedor[nombre]</td>

		</tr>

		<tr>
		
		<td style="border-bottom: 1px solid #666; background-color:white; width:540px"></td>

		</tr>

	</table>




	<table style="font-size:10px; padding:5px 10px;">
            <head>
		<tr>
		
		<td style="border: 1px solid #666; background-color:#0c045e;color:#fff; width:260px; text-align:center">Producto</td>
		<td style="border: 1px solid #666; background-color:#0c045e;color:#fff; width:80px; text-align:center">Cantidad</td>
		<td style="border: 1px solid #666; background-color:#0c045e;color:#fff; width:100px; text-align:center">Valor Unit.</td>
		<td style="border: 1px solid #666; background-color:#0c045e;color:#fff; width:100px; text-align:center">Valor Total</td>

		</tr>
        </head>
        
        <tbody>
            <tr>
			
			<td style="border: 1px solid #666; color:#333; background-color:white; width:260px; text-align:center">
				$item[descripcion]
			</td>

			<td style="border: 1px solid #666; color:#333; background-color:white; width:80px; text-align:center">
				$item[cantidad]
			</td>

			<td style="border: 1px solid #666; color:#333; background-color:white; width:100px; text-align:center">$ 
				$valorUnitario
			</td>

			<td style="border: 1px solid #666; color:#333; background-color:white; width:100px; text-align:center">$ 
				$precioTotal
			</td>


		</tr>
            
        </tbody>
	</table>



	





	<table style="font-size:10px; padding:5px 10px;">

		<tr>

			<td style="color:#333; background-color:white; width:340px; text-align:center"></td>

			<td style="border-bottom: 1px solid #666; background-color:white; width:100px; text-align:center"></td>

			<td style="border-bottom: 1px solid #666; color:#333; background-color:white; width:100px; text-align:center"></td>

		</tr>
		
		<tr>
		
			<td style="border-right: 1px solid #666; color:#333; background-color:white; width:340px; text-align:center"></td>

			<td style="border: 1px solid #666;  background-color:white; width:100px; text-align:center">
				Neto:
			</td>

			<td style="border: 1px solid #666; color:#333; background-color:white; width:100px; text-align:center">
				$ $neto
			</td>

		</tr>

		<tr>

			<td style="border-right: 1px solid #666; color:#333; background-color:white; width:340px; text-align:center"></td>

			<td style="border: 1px solid #666; background-color:white; width:100px; text-align:center">
				Impuesto:
			</td>
		
			<td style="border: 1px solid #666; color:#333; background-color:white; width:100px; text-align:center">
				$ $impuesto
			</td>

		</tr>

		<tr>
		
			<td style="border-right: 1px solid #666; color:#333; background-color:white; width:340px; text-align:center"></td>

			<td style="border: 1px solid #666; background-color:white; width:100px; text-align:center">
				Total:
			</td>
			
			<td style="border: 1px solid #666; color:#333; background-color:white; width:100px; text-align:center">
				$ $total
			</td>

		</tr>


	</table>