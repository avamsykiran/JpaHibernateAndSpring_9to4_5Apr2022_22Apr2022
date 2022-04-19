<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page import="com.cts.bta.entity.TxnType" %>

<html>
	<head>
		<title>Statement Page</title>
	</head>
	<body>
		<jsp:include page="/headerSegment" />
		
		<c:choose>
			<c:when test="${txns==null || txns.isEmpty() }">
				<p><strong>No Transaction Made Yet!!</strong></p>
			</c:when>
			<c:otherwise>
				<table style="width:80%;margin:auto;border:1px solid black;">
					<thead>
						<tr>
							<th>TxnId</th>
							<th>Date</th>
							<th>Header</th>
							<th>Credit</th>
							<th>Debit</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="txn" items="${txns }">
							<tr>
								<td style="text-align:right">${txn.txnId }</td>
								<td style="text-align:center">${txn.txnDate }</td>
								<td style="text-align:left">${txn.header }</td>
								<td style="text-align:right">${txn.type==TxnType.CREDIT?txn.amount+"":"" }</td>
								<td style="text-align:right">${txn.type==TxnType.DEBIT?txn.amount+"":"" }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</body>
</html>