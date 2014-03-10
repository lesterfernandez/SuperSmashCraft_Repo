package me.thewarlord315.commands;

import me.thewarlord315.supersmashcraft.Arena;
import me.thewarlord315.supersmashcraft.ArenaManager;
import me.thewarlord315.supersmashcraft.MessageManager;
import me.thewarlord315.supersmashcraft.Arena.ArenaState;
import me.thewarlord315.supersmashcraft.MessageManager.MessageType;
import me.thewarlord315.supersmashcraft.SettingsManager;

import org.bukkit.entity.Player;

public class Delete extends SuperCommand {

	public void onCommand(Player p, String[] args) {
		if (args.length == 0) {
			MessageManager.getInstance().msg(p, MessageType.BAD, "You must specify an arena number!");
			return;
		}

		int id = -1;

		try { id = Integer.parseInt(args[0]); }
		catch (Exception e) {
			MessageManager.getInstance().msg(p, MessageType.BAD, args[0] + " is not a valid number!");
			return;
		}

		Arena a = ArenaManager.getInstance().getArena(id);

		if (a == null) {
			MessageManager.getInstance().msg(p, MessageType.BAD, "There is no arena with ID " + id + "!");
			return;
		}

		if (a.getState() == ArenaState.STARTED) {
			MessageManager.getInstance().msg(p, MessageType.BAD, "Arena " + id + " is ingame!");
			return;
		}

		SettingsManager.getArenas().set("arenas." + id + "", null);

		ArenaManager.getInstance().setupArenas();

        MessageManager.getInstance().msg(p, MessageType.GOOD, "Deleted arena " + id + "!");
	}

public Delete() {
        super("Delete an arena.", "<id>", "delete");
}
}