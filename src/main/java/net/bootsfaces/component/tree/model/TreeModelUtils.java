package net.bootsfaces.component.tree.model;

import java.util.List;

import net.bootsfaces.utils.BsfUtils;

public class TreeModelUtils {
	
	/**
	 * Render the node model as JSON
	 * @param nodeList
	 * @return
	 */
	public static String renderModelAsJson (List<Node> nodeList) {
		if(nodeList != null && nodeList.size() > 0)
			return renderSubnodes(nodeList);
		
		return "";
	}
	
	private static String renderNode(Node node) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("{");
		// NODE ID
		if(node.getNodeId() != -1) {
			sb.append("\"nodeId\": " + node.getNodeId() + ", ");
		}
		// TEXT
		if(BsfUtils.StringIsValued(node.getText())) {
			sb.append("\"text\": \"" + node.getText() + "\", ");
		}
		// ICON
		if(BsfUtils.StringIsValued(node.getIcon())) {
			sb.append("\"icon\": \"" + node.getIcon() + "\", ");
		}
		// SELECTED ICON
		if(BsfUtils.StringIsValued(node.getSelectedIcon())) {
			sb.append("\"selectedIcon\": \"" + node.getSelectedIcon() + "\", ");
		}
		// COLOR
		if(BsfUtils.StringIsValued(node.getColor())) {
			sb.append("\"color\": \"" + node.getColor() + "\", ");
		}
		// BACK COLOR
		if(BsfUtils.StringIsValued(node.getBackColor())) {
			sb.append("\"backColor\": \"" + node.getBackColor() + "\", ");
		}
		// HREF
		if(BsfUtils.StringIsValued(node.getHRef())) {
			sb.append("\"href\": \"" + node.getHRef() + "\", ");
		}	
		// TAGS
		if(node.getTags() != null && node.getTags().size() > 0) {
			sb.append("\"tags\": [");
			for(String tag: node.getTags()) {
				sb.append("'" + tag + "',");
			}
			sb.append("''],");
		}
		// NODES:
		if(node.getSubNodes() != null && node.getSubNodes().size() > 0) {
			sb.append("\"nodes\": ");
			sb.append(renderSubnodes(node.getSubNodes()));
			sb.append(",");
		}
		
		sb.append("\"selectable\": " + node.isSelectable() + ", ");
		sb.append("\"state\": {");
		sb.append("\"checked\": " + node.isChecked() + ", ");
		sb.append("\"disabled\": " + node.isDisabled() + ", ");
		sb.append("\"expanded\": " + node.isExpanded() + ", ");
		sb.append("\"selected\": " + node.isSelected() + " ");
		sb.append("}");
		sb.append("}");
		
		return sb.toString();
	}
	
	private static String renderSubnodes(List<Node> nodeList) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		int idx = 0;
		for(Node n: nodeList) {
			if(idx > 0) {
				sb.append(",");
			}
			idx++;
			sb.append(renderNode(n));
		}
		sb.append("]");
		
		return sb.toString();
	}
	

}