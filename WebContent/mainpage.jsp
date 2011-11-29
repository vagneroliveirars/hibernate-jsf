<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t"  uri="http://myfaces.apache.org/tomahawk"%>

<f:loadBundle basename="messages" var="msgs"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Pagina Principal</title>
	</head>
	<body>
		<f:view>
			<h:outputText value="#{msgs['bemvindo']}"/>
			<h:outputText value="#{autenticador.login}"/>!
			<br/>
			<t:panelTabbedPane bgcolor="yellow" width="30%">
				<t:panelTab label="Fornecedores">
					<h:form>
						<h:panelGrid>
							<h:outputText value="#{msgs['fornecedor-nome']}"/>
							<h:inputText id="nome" required="true" value="#{FornecedorHandler.fornecedor.nome}">
								<f:validateLength minimum="5"/>
							</h:inputText>
							<h:message for="nome"/>
							<h:outputText value="#{msgs['fornecedor-descricao']}"/>
							<h:inputTextarea value="#{FornecedorHandler.fornecedor.descricao}"/>
							<h:commandButton value="Salvar" action="#{FornecedorHandler.salva}"/>
						</h:panelGrid>				
					</h:form>
			
					<h:form>
						<h:dataTable id="fornecedoresTable" rendered="#{not empty FornecedorHandler.fornecedores}" border="1" var="f" value="#{FornecedorHandler.fornecedores}" rows="5">
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
							<h:column>
								<f:facet name="header">
									<h:outputText value="Alterar"/>
								</f:facet>
								<t:commandLink actionListener="#{FornecedorHandler.escolheFornecedor}">
									<h:outputText value="(alterar)"/>
									<f:param id="editId" name="id" value="#{f.id}"/>
								</t:commandLink>
							</h:column>					
						</h:dataTable>
						<t:dataScroller for="fornecedoresTable" paginator="true" paginatorMaxPages="7"/>
					</h:form>
				</t:panelTab>
				
				<t:panelTab label="Contas a pagar" rendered="#{not empty FornecedorHandler.fornecedores}">
					<h:form>
						<h:panelGrid>
							<h:outputText value="Criar conta para fornecedor:"/>
							<h:selectOneMenu binding="#{ContaPagarHandler.fornecedorSelecionado}">
								<f:selectItems value="#{ContaPagarHandler.fornecedoresParaComboBox}"/>
							</h:selectOneMenu>
							<h:outputText value="Descrição:"/>
							<h:inputText value="#{ContaPagarHandler.contaPagar.descricao}"/>
							<h:outputText value="Data de pagamento:"/>
							<t:inputCalendar renderAsPopup="true" value="#{ContaPagarHandler.contaPagar.data.time}"/>
							<h:outputText value="Valor:"/>
							<h:inputText value="#{ContaPagarHandler.contaPagar.valor}"/>
							<h:selectBooleanCheckbox value="#{ContaPagarHandler.contaPagar.pago}"/>
							<h:outputText value="Pago"/>
							<h:commandButton actionListener="#{ContaPagarHandler.salva}" value="Gravar"/>
							<h:messages/>
							
							<t:dataList value="#{ContaPagarHandler.contas}" var="conta" layout="unorderedList">
								<h:outputText value="#{conta.descricao}"/>
							</t:dataList>
						</h:panelGrid>
					</h:form>
				</t:panelTab>
			</t:panelTabbedPane>
		</f:view>
	</body>
</html>