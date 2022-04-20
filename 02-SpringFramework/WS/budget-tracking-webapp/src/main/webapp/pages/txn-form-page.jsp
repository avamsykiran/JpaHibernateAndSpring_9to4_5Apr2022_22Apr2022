<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="com.cts.bta.entity.TxnType" %>

<html>
	<head>
		<title>Transaction Page</title>
		<style>
			form{
				width:30%;
				display:block;
				margin:auto;
				padding:5px;
			}
			label,input,select{
				display:block;
				width:100%;
			}
			label{
				font-weight:bolder;
			}
			div{
				margin-bottom:8px;
			}
		</style>
	</head>
	<body>
		<jsp:include page="/headerSegment" />
		
		<form:form method="POST" modelAttribute="txn">
			<div>
				<form:label path="txnId">Transaction Id</form:label>
				<form:input path="txnId" readonly="true"/>
			</div>
			<div>
				<form:label path="header">Purpose / Description</form:label>
				<form:input path="header"/>
				<form:errors path="header" />
			</div>
			<div>
				<form:label path="amount">Amount</form:label>
				<form:input path="amount" type="number"/>
				<form:errors path="amount" />
			</div>
			<div>
				<form:label path="txnDate">Date Of Transaction</form:label>
				<form:input path="txnDate" type="date"/>
				<form:errors path="txnDate" />
			</div>
			<div>
				<form:label path="type">Type</form:label>
				<form:select path="type">
					<form:option value="">---SELECT---</form:option>
					<form:options items="${TxnType.values() }"/>
				</form:select>
				<form:errors path="type" />
			</div>
			<div style="text-align:right">
				<button>Save Transaction</button>
			</div>
		</form:form>
	</body>
</html>