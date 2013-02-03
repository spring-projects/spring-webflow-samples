<div id="modalDialogContainer">
	<p class="notice">This is step 2 of the flow embedded in a modal dialog.</p>
	<form id="step2" action="${flowExecutionUrl}" method="POST">
		<button id="cancel" type="submit" name="_eventId_cancel">Cancel</button>
		<button id="previous" type="submit" name="_eventId_previous">&lt;&lt; Previous</button>
		<button id="finish" type="submit" name="_eventId_finish">Finish &gt;&gt;</button>
		<script type="text/javascript">
			Spring.addDecoration(new Spring.AjaxEventDecoration({elementId:'finish',event:'onclick',formId:'step2',params:{fragments:"body"}}));
			Spring.addDecoration(new Spring.AjaxEventDecoration({elementId:'previous',event:'onclick',formId:'step2',params:{fragments:"body"}}));
			Spring.addDecoration(new Spring.AjaxEventDecoration({elementId:'cancel',event:'onclick',formId:'step2',params:{fragments:"body"}}));
		</script>
	</form>
</div>