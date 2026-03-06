import { ReactNode } from "react";
import { cn } from "../../lib/utils";

interface SectionProps {
  children: ReactNode;
  className?: string;
  id?: string;
  noBorder?: boolean;
  variant?: "full" | "auto";
}

export default function Section({ children, className, id, noBorder = false, variant = "auto" }: SectionProps) {
	return (
		<section
			id={id}
			className={cn(
				"w-full max-w-[1200px] mx-auto px-4 sm:px-6 lg:px-8 py-24 md:py-40",
				variant === "full" && "min-h-screen",
				!noBorder && "border-b border-gray-200 dark:border-gray-800",
				className
			)}
		>
			{children}
		</section>
	);
}
