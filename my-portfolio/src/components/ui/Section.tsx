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
				"w-full max-w-[1200px] mx-auto px-4 sm:px-6 lg:px-8 pt-16 pb-24 md:pt-20 md:pb-32",
				variant === "full" && "min-h-screen flex flex-col justify-center",
				!noBorder && "border-b border-white/5",				className
			)}
		>
			{children}
		</section>
	);
}
