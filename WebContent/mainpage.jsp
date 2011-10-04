<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Pagina Principal</title>
	</head>
	<body>
		<f:view>
			Bem vindo <h:outputText value="#{autenticador.login}"/>!
			<h:form>
				Nome:
				<h:inputText value="#{FornecedorHandler.fornecedor.nome}"/><br/>
				Descricao:
				<h:inputTextarea value="#{FornecedorHandler.fornecedor.descricao}"/><br/>
				<h:commandButton value="Salvar" action="#{FornecedorHandler.salva}"/>				
			</h:form>
			
			<h:form>
				<h:dataTable rendered="#{not empty FornecedorHandler.fornecedores}" border="1" var="f" value="#{FornecedorHandler.fornecedores}">
					<h:column>
						<f:facet name="header">
							<h:outputText value="Id"/>
						</f:facet>
						<h:outputText value="#{f.id}"/>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Nome"/>
						</f:facet>
						<h:outputText value="#{f.nome}"/>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Descricao"/>
						</f:facet>
						<h:outputText value="#{f.descricao}"/>
					</h:column>											
				</h:dataTable>
			</h:form>	
		</f:view>
	</body>
</html>