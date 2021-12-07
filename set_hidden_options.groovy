import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.customfields.manager.OptionsManager
import com.atlassian.jira.issue.customfields.option.Option

def customFieldManager = ComponentAccessor.customFieldManager
def optionsManager = ComponentAccessor.optionsManager
def product = getFieldByName("Product.")

def productCF = customFieldManager.getCustomFieldObjectsByName("Product.")[0]
def config = productCF.getRelevantConfig(getIssueContext())
def options = optionsManager.getOptions(config)

def optionSet1 = [
	'App',
	'EBDA',
	'HB',
	'Reporting API',
	'S2S',
	'Tag'
]

def optionSet2 = [
	'App',
    'DAP',
    'Direct Inventory',
	'EBDA',
	'HB',
	'Reporting API',
	'S2S',
	'Tag'
]

def field = getFieldById(getFieldChanged())
def field_val = field.getValue()



def optionToSelect = "S2S"
def optionToSelect2 = "HB"
def optionToSelect3 = "EBDA"

def cf1 = getFieldByName("Questionnaire")
def cf2 = getFieldByName("Publisher ID")

cf1.setHidden(true)
cf2.setHidden(true)

if (field_val == optionToSelect || field_val ==  optionToSelect2) {
    cf1.setHidden(false)
} else {
    cf1.setHidden(true)
}

if (field_val == optionToSelect3) {
    cf2.setHidden(false)
} else {
    cf2.setHidden(true)
}
